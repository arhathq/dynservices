package dynservices.core.types.metatypes;

import dynservices.core.types.Value;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Alexander Kuleshov
 */
public class ValueDefinition implements ElementDefinition {

    private ValueType type;
    private Value defaultValue;

    private ValueDefinition(ValueType type, Value defaultValue) {
        this.type = type;
        this.defaultValue = defaultValue;
    }

    @Override
    public List<ElementDefinition> getElements() {
        return new ArrayList<>();
    }

}
