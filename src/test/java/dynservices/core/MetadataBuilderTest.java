package dynservices.core;

import dynservices.core.complex.types.AddressMetadata;
import dynservices.core.complex.types.CustomerMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class MetadataBuilderTest {

    @Test
    public void testBuildMetadata() {
        ElementMetadata metadata = MetadataBuilder.create().
                withRootElement("service", ElementType.Container).
                withElement("customer", ElementType.Container).
                withChildElements().
                withElement("custNo", ElementType.String).
                withElement("firstName", ElementType.String).
                withElement("lastName", ElementType.String).
                withElement("birthDate", ElementType.Date).
                withElement("addresses", ElementType.Container).
                withChildElements().
                withElement("address", ElementType.Container).
                withChildElements().
                withElement("country", ElementType.String).
                withElement("city", ElementType.String).
                build();

        assertTrue(metadata.getChildren().size() == 1);

        ElementMetadata customerMetadata = metadata.getChildren().get(0);

        assertTrue(customerMetadata.getChildren().size() == 5);
    }

    @Test
    public void testBuildComplexMetadata() {
        ElementMetadata metadata = MetadataBuilder.create().
                withRootElement("service", ElementType.Container).
                withComplexElement(new CustomerMetadata()).
                withComplexElement(new AddressMetadata()).
                build();

        assertTrue(metadata.getChildren().size() == 2);

        ElementMetadata nestedMetadata = MetadataBuilder.create().
                withRootElement("service", ElementType.Container).
                withComplexElement(new CustomerMetadata()).
                withChildElements().
                withElement("addresses", ElementType.Container).
                withChildElements().
                withComplexElement(new AddressMetadata()).
                build();

        assertTrue(nestedMetadata.getChildren().size() == 1);
    }

}
