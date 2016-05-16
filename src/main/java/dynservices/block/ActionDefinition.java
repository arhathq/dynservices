package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;

/**
 * @author Alexander Kuleshov
 */
public class ActionDefinition extends AbstractComplexDefinition {
    protected ActionDefinition() {
        super(BlockType.ACTION.id());

        ArrayList<ElementDefinition> fields = new ArrayList<>();
        fields.add(ElementDefinitionBuilder.createFor(BlockType.ACTION_INPUT_PARAMETER.id(), ElementType.Custom).build());
        fields.add(ElementDefinitionBuilder.createFor(BlockType.ACTION_OUTPUT_PARAMETER.id(), ElementType.Custom).build());
        setFields(fields);

    }
}
