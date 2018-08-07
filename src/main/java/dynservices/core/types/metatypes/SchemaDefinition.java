package dynservices.core.types.metatypes;

import java.util.List;


/**
 * @author Alexander Kuleshov
 */
public class SchemaDefinition implements ElementDefinition {

    private String name;
    private SchemaType type;
    private List<ElementDefinition> elements;

    private SchemaDefinition(String name, SchemaType type, List<ElementDefinition> elements) {
        this.name = name;
        this.type = type;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public SchemaType getType() {
        return type;
    }

    @Override
    public List<ElementDefinition> getElements() {
        return elements;
    }
}
