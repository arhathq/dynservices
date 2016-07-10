package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.complex.ComplexDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arhathq on 03.07.2016.
 */
public class RequestDefinitionImpl implements RequestDefinition {

    private List<ElementDefinition> parameters;

    private ComplexDefinition body;

    public RequestDefinitionImpl(List<ElementDefinition> parameters, ComplexDefinition body) {
        this.parameters = new ArrayList<>(parameters);
        this.body = body;
    }

    @Override
    public List<ElementDefinition> getRequestParameters() {
        return parameters;
    }

    @Override
    public ComplexDefinition getRequestBody() {
        return body;
    }
}
