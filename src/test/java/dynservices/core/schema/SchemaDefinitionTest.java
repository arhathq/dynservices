package dynservices.core.schema;

import dynservices.core.PropertyType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class SchemaDefinitionTest {
    @Test
    public void createServiceDefinition() {
        SchemaDefinition serviceDefinition = SchemaDefinitionBuilder.createFor(SchemaType.SERVICE).
                withProperty("name", PropertyType.String).
                withProperty("version", PropertyType.String).
                withField(SchemaDefinitionBuilder.createFor(SchemaType.REQUEST)).
                withField(SchemaDefinitionBuilder.createFor(SchemaType.ACTION)).
                withField(SchemaDefinitionBuilder.createFor(SchemaType.RESPONSE)).
                withField(SchemaDefinitionBuilder.createFor(SchemaType.ERROR)).
                build();

        assertTrue(serviceDefinition.getProperties().size() == 2);
        assertTrue(serviceDefinition.getFields().size() == 4);
    }
}
