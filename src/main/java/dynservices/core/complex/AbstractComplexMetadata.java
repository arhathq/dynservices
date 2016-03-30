package dynservices.core.complex;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementMetadataImpl;
import dynservices.core.ElementType;
import dynservices.core.MetadataBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class AbstractComplexMetadata implements ComplexMetadata {

    private String name;
    private ElementType type = ElementType.Custom;
    private Map<String, String> properties = new HashMap<>();
    private List<ElementMetadata> fields = new ArrayList<>();

    protected AbstractComplexMetadata(String name) {
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
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public List<ElementMetadata> getFields() {
        return fields;
    }

    protected void setFields(List<ElementMetadata> fields) {
        this.fields.addAll(fields);
    }

    @Override
    public ComplexMetadata visit(ComplexMetadataVisitor visitor) {
        visitor.visit(fields);
        return this;
    }

    @Override
    public ElementMetadata asElementMetadata() {
        MetadataBuilder builder = MetadataBuilder.createFor(name, type);
        builder.withProperties(properties);
        for (ElementMetadata em : fields) {
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