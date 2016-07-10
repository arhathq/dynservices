package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.complex.ComplexDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arhathq on 23.05.2016.
 */
public class RequestDefinitionBuilder {

    private List<ElementDefinition> parameters = new ArrayList<>();

    private ComplexDefinition body;

    public RequestDefinitionBuilder withParameter(ElementDefinition parameter) {
        parameters.add(parameter);
        return this;
    }

    public RequestDefinitionBuilder withBody(ComplexDefinition body) {
        this.body = body;
        return this;
    }

    public RequestDefinition build() {
        return new RequestDefinitionImpl(parameters, body);
    }

}