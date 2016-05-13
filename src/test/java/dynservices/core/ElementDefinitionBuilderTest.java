package dynservices.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class ElementDefinitionBuilderTest {

    @Test
    public void testBuildMetadata() {
        ElementDefinition metadata = ElementDefinitionBuilder.createFor("service", ElementType.Container).
                withField(ElementDefinitionBuilder.createFor("customer", ElementType.Container).
                        withField("custNo", ElementType.String).
                        withField("firstName", ElementType.String).
                        withField("lastName", ElementType.String).
                        withField("birthDate", ElementType.Date).
                        withField(ElementDefinitionBuilder.createFor("addresses", ElementType.Container).
                                withField(ElementDefinitionBuilder.createFor("address", ElementType.Container).
                                        withField("country", ElementType.String).
                                        withField("city", ElementType.String)
                                )
                        )
                ).
                build();

        assertTrue(metadata.getFields().size() == 1);

        ElementDefinition customerMetadata = metadata.getFields().get(0);

        assertTrue(customerMetadata.getFields().size() == 5);
    }

    @Test
    public void testBuildMetadataTwice() {
        ElementDefinitionBuilder builder = ElementDefinitionBuilder.createFor("username", ElementType.String);

        builder.build();
        try {
            builder.build();
            fail("No exception was thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }

    @Test
    public void testBuildMetadataWithProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("alias", "cs");
        properties.put("validation", "true");

        ElementDefinition metadata = ElementDefinitionBuilder.createFor("service", ElementType.String).
                withProperty("persisted", "true").
                withProperties(properties).
                build();

        assertNotNull(metadata.getProperties().get("persisted"));
        assertNotNull(metadata.getProperties().get("alias"));
        assertNotNull(metadata.getProperties().get("validation"));
    }
}