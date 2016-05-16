package dynservices.block;

import dynservices.core.ElementDefinitionImpl;
import dynservices.core.ElementType;

/**
 * @author Alexander Kuleshov
 */
public class ResponseDefinition extends ElementDefinitionImpl {

    public ResponseDefinition() {
        super(BlockType.RESPONSE.id(), ElementType.Container);
    }
}
