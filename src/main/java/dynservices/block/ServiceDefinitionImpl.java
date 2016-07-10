package dynservices.block;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kuleshov
 */
public class ServiceDefinitionImpl implements ServiceDefinition {

    private String name;
    private String version;
    private String httpMethod;
    private String pathPrefix;
    private String pathSuffix;

    private RequestDefinition requestDefinition;
    private List<ActionDefinition> actionsDefinitions = new ArrayList<>(1);
    private ResponseDefinition responseDefinition;
    private ErrorDefinition errorDefinition;

    ServiceDefinitionImpl(String name, String version, String httpMethod, String pathPrefix, String pathSuffix) {
        this.name = name;
        this.version = version;
        this.httpMethod = httpMethod;
        this.pathPrefix = pathPrefix;
        this.pathSuffix = pathSuffix;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getHttpMethod() {
        return httpMethod;
    }

    @Override
    public String getPathPrefix() {
        return pathPrefix;
    }

    @Override
    public String getPathSuffix() {
        return pathSuffix;
    }

    @Override
    public RequestDefinition getRequestDefinition() {
        return requestDefinition;
    }

    public void setRequestDefinition(RequestDefinition requestDefinition) {
        this.requestDefinition = requestDefinition;
    }

    @Override
    public List<ActionDefinition> getActionsDefinitions() {
        return actionsDefinitions;
    }

    public void setActionsDefinitions(List<ActionDefinition> actionsDefinitions) {
        this.actionsDefinitions.addAll(actionsDefinitions);
    }

    @Override
    public ResponseDefinition getResponseDefinition() {
        return responseDefinition;
    }

    public void setResponseDefinition(ResponseDefinition responseDefinition) {
        this.responseDefinition = responseDefinition;
    }

    @Override
    public ErrorDefinition getErrorDefinition() {
        return errorDefinition;
    }

    public void setErrorDefinition(ErrorDefinition errorDefinition) {
        this.errorDefinition = errorDefinition;
    }
}
