package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.PropertyType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class ServiceDefinitionTest {
    @Test
    public void createServiceDefinition() {
        ElementDefinition serviceDefinition = ElementDefinitionBuilder.createFor("service", ElementType.Container).
                withProperty("name", PropertyType.String).
                withProperty("version", PropertyType.String).
                withField(ElementDefinitionBuilder.createFor("request", ElementType.Container)).
                withField(ElementDefinitionBuilder.createFor("actions", ElementType.Container)).
                withField(ElementDefinitionBuilder.createFor("response", ElementType.Container)).
                withField(ElementDefinitionBuilder.createFor("error", ElementType.Container)).
                build();

        assertTrue(serviceDefinition.getProperties().size() == 2);
        assertTrue(serviceDefinition.getFields().size() == 4);
    }
}
