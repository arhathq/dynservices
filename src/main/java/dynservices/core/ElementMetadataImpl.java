package dynservices.core;

import java.util.*;

/**
 *
 */
public class ElementMetadataImpl implements ElementMetadata {

    private String name;
    private ElementType type;
    private List<ElementMetadata> fields = new ArrayList<>();
    private Map<String, String> properties = new HashMap<>();

    protected ElementMetadataImpl(String name, ElementType type) {
        this(name, type, Collections.emptyList(), Collections.emptyMap());
    }

    protected ElementMetadataImpl(String name, ElementType type, List<ElementMetadata> fields, Map<String, String> properties) {
        this.name = name;
        this.type = type;
        this.fields.addAll(fields);
        this.properties.putAll(properties);
    }

    protected ElementMetadataImpl(ElementMetadata em) {
        this.name = em.getName();
        this.type = em.getType();
        this.fields.addAll(em.getFields());
        this.properties.putAll(em.getProperties());
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

}