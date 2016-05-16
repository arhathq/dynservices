package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;

/**
 * @author Alexander Kuleshov
 */
public class RequestDefinition extends AbstractComplexDefinition {

    public RequestDefinition() {
        super(BlockType.REQUEST.id());

        ArrayList<ElementDefinition> fields = new ArrayList<>();
        fields.add(ElementDefinitionBuilder.createFor(BlockType.REQUEST_PARAMETER.id(), ElementType.Custom).build());
        fields.add(ElementDefinitionBuilder.createFor(BlockType.REQUEST_BODY.id(), ElementType.Container).build());
        setFields(fields);
    }

}
