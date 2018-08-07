package dynservices.core.types.metatypes;

import dynservices.core.types.ElementResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author Alexander Kuleshov
 */
public class FieldDefinition implements ElementDefinition {

    private String name;
    private Optional<String> alias;
    private Boolean required;
    private ValueDefinition valueDefinition;
    private Optional<ElementResolver> elementResolver;

    private FieldDefinition(String name, Optional<String> alias, Boolean required, ValueDefinition valueDefinition, Optional<ElementResolver> elementResolver) {
        this.name = name;
        this.alias = alias;
        this.required = required;
        this.valueDefinition = valueDefinition;
        this.elementResolver = elementResolver;
    }

    @Override
    public List<ElementDefinition> getElements() {
        return new ArrayList<>();
    }
}
