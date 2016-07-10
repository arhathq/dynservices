package dynservices.block;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ServiceDefinitionBuilder {

    private String name;
    private String version;
    private String httpMethod;
    private String pathPrefix;
    private String pathSuffix;
    private RequestDefinition requestDefinition;
    private List<ActionDefinition> actionsDefinitions = new ArrayList<>();
    private ResponseDefinition responseDefinition;
    private ErrorDefinition errorDefinition;

    public ServiceDefinitionBuilder(String name) {
        this.name = name;
    }

    public static ServiceDefinitionBuilder createFor(String name) {
        return new ServiceDefinitionBuilder(name);
    }

    public ServiceDefinitionBuilder withVersion(String version) {
        this.version = version;
        return this;
    }

    public ServiceDefinitionBuilder withHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public ServiceDefinitionBuilder withPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
        return this;
    }

    public ServiceDefinitionBuilder withPathSuffix(String pathSuffix) {
        this.pathSuffix = pathSuffix;
        return this;
    }

    public ServiceDefinitionBuilder withRequestDefinition(RequestDefinition requestDefinition) {
        this.requestDefinition = requestDefinition;
        return this;
    }

    public ServiceDefinitionBuilder withActionDefinition(ActionDefinition actionDefinition) {
        actionsDefinitions.add(actionDefinition);
        return this;
    }

    public ServiceDefinitionBuilder withResponseDefinition(ResponseDefinition responseDefinition) {
        this.responseDefinition = responseDefinition;
        return this;
    }

    public ServiceDefinitionBuilder withErrorDefinition(ErrorDefinition errorDefinition) {
        this.errorDefinition = errorDefinition;
        return this;
    }

    public ServiceDefinition build() {
        checkBeforeBuild();
        ServiceDefinitionImpl s = new ServiceDefinitionImpl(name, version, httpMethod, pathPrefix, pathSuffix);
        s.setRequestDefinition(requestDefinition);
        s.setActionsDefinitions(actionsDefinitions);
        s.setResponseDefinition(responseDefinition);
        s.setErrorDefinition(errorDefinition);
        clearAfterBuild();
        return s;
    }

    private void checkBeforeBuild() {
        if (name == null) {
            throw new IllegalStateException("ServiceDefinition has been already built");
        }
    }

    private void clearAfterBuild() {
        name = null;
        version = null;
        requestDefinition = null;
        actionsDefinitions = null;
        responseDefinition = null;
        errorDefinition = null;
    }

}
