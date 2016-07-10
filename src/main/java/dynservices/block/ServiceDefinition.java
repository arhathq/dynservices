package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.PropertyType;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ServiceDefinition {

    String getName();

    String getVersion();

    String getHttpMethod();

    String getPathPrefix();

    String getPathSuffix();

    RequestDefinition getRequestDefinition();

    List<ActionDefinition> getActionsDefinitions();

    ResponseDefinition getResponseDefinition();

    ErrorDefinition getErrorDefinition();

}