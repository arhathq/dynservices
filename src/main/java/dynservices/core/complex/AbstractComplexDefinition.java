package dynservices.core.complex;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementType;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.PropertyType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class AbstractComplexDefinition implements ComplexDefinition {

    private String name;
    private ElementType type = ElementType.Custom;
    private Map<String, PropertyType> properties = new HashMap<>();
    private List<ElementDefinition> fields = new ArrayList<>();

    protected AbstractComplexDefinition(String name) {
        checkForName(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public Map<String, PropertyType> getProperties() {
        return properties;
    }

    protected void setProperties(Map<String, PropertyType> properties) {
        this.properties.putAll(properties);
    }

    @Override
    public List<ElementDefinition> getFields() {
        return fields;
    }

    protected void setFields(List<ElementDefinition> fields) {
        this.fields.addAll(fields);
    }

    @Override
    public ComplexDefinition visit(ComplexMetadataVisitor visitor) {
        visitor.visit(fields);
        return this;
    }

    @Override
    public ElementDefinition asElementMetadata() {
        ElementDefinitionBuilder builder = ElementDefinitionBuilder.createFor(name, type);
        builder.withProperties(properties);
        for (ElementDefinition em : fields) {
            builder.withField(em);
        }
        return builder.build();
    }

    private void checkForName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name must be defined");
        }
    }
}