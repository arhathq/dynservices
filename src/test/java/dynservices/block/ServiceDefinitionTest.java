package dynservices.block;

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
        String serviceName = "getAddresses";
        String serviceVersion = "1.0";
        String serviceMethod = "GET";
        String servicePrefix = "addresses";
        String serviceSuffix = "billing";

        ServiceDefinition schema = ServiceDefinitionBuilder.createFor(serviceName).
                withVersion(serviceVersion).
                withHttpMethod(serviceMethod).
                withPathPrefix(servicePrefix).
                withPathSuffix(serviceSuffix).
//                withRequestDefinition().
//                withActionDefinition().
//                withActionDefinition().
//                withResponseDefinition().
//                withErrorDefinition().
                build();

        assertTrue(serviceName.equals(schema.getName()));
        assertTrue(serviceVersion.equals(schema.getVersion()));
        assertTrue(serviceMethod.equals(schema.getHttpMethod()));
        assertTrue(servicePrefix.equals(schema.getPathPrefix()));
        assertTrue(serviceSuffix.equals(schema.getPathSuffix()));
    }
}