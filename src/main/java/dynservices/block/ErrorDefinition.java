package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;

/**
 * @author Alexander Kuleshov
 */
public class ErrorDefinition extends AbstractComplexDefinition {

    public ErrorDefinition() {
        super(BlockType.ERROR.id());

        ArrayList<ElementDefinition> fields = new ArrayList<>();
        fields.add(ElementDefinitionBuilder.createFor(BlockType.ERRORCODE.id(), ElementType.String).build());
        fields.add(ElementDefinitionBuilder.createFor(BlockType.ERRORDESCRIPTION.id(), ElementType.String).build());
        setFields(fields);
    }

}
