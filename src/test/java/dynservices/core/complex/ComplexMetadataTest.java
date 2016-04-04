package dynservices.core.complex;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementType;
import dynservices.core.MetadataBuilder;
import dynservices.core.complex.types.AddressMetadata;
import dynservices.core.complex.types.CustomerMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class ComplexMetadataTest {

    @Test
    public void testBuildComplexMetadata() {
        ElementMetadata metadata = MetadataBuilder.createFor("service", ElementType.Container).
                withField(new CustomerMetadata()).
                withField(new AddressMetadata()).
                build();

        assertTrue(metadata.getFields().size() == 2);
    }

    @Test
    public void testBuildComplexMetadataWithNestedData() {
        ElementMetadata nestedMetadata = MetadataBuilder.createFor("service", ElementType.Container).
                withField(MetadataBuilder.createFor(new CustomerMetadata()).
                        withField(MetadataBuilder.createFor("addresses", ElementType.Container).
                                withField(new AddressMetadata())
                        )
                ).
                build();

        assertTrue(nestedMetadata.getFields().size() == 1);
    }

    @Test
    public void testModifyComplexMetadata() {
        CustomerMetadata cm = new CustomerMetadata();

        Set<String> originNames = new HashSet<>();
        originNames.addAll(cm.getFields().stream().map(ElementMetadata::getName).collect(Collectors.toList()));

        ComplexMetadataVisitor visitor = ComplexMetadataVisitor.newVisitor().addField("middleName", ElementType.String).removeField("lastName");
        cm.visit(visitor);

        assertTrue(cm.getFields().size() == 3);

        Set<String> modifiedNames = new HashSet<>();
        modifiedNames.addAll(cm.getFields().stream().map(ElementMetadata::getName).collect(Collectors.toList()));

        assertTrue(!originNames.equals(modifiedNames));
    }

}
