package dynservices.core;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suitable class for generation of metadata. It is not a thread safe
 */
public class MetadataBuilder {

    private String name;
    private ElementType type;
    private List<ElementMetadata> fields = new ArrayList<>();
    private Map<String, String> properties = new HashMap<>();

    private MetadataBuilder(String name, ElementType type) {
        checkForName(name);
        this.name = name;
        this.type = type;
    }

    private MetadataBuilder(ElementMetadata em) {
        this.name = em.getName();
        this.type = em.getType();
        fields.addAll(em.getFields());
    }

    public static MetadataBuilder createFor(String name, ElementType type) {
        return new MetadataBuilder(name, type);
    }

    public static MetadataBuilder createFor(ElementMetadata em) {
        return new MetadataBuilder(em);
    }

    public MetadataBuilder withField(String name, ElementType type) {
        checkForName(name);
        fields.add(new ElementMetadataImpl(name, type));
        return this;
    }

    public MetadataBuilder withField(ElementMetadata em) {
        fields.add(em);
        return this;
    }

    public MetadataBuilder withField(MetadataBuilder builder) {
        fields.add(builder.build());
        return this;
    }

    public MetadataBuilder withProperties(Map<String, String> properties) {
        this.properties.putAll(properties);
        return this;
    }

    public MetadataBuilder withProperty(String name, String value) {
        properties.put(name, value);
        return this;
    }

    public ElementMetadata build() {
        return new ElementMetadataImpl(name, type, fields, properties);
    }

    private void checkForName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalStateException("No name defined");
        }
    }
}