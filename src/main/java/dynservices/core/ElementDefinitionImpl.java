package dynservices.core;

import java.util.*;

/**
 *
 */
public class ElementDefinitionImpl implements ElementDefinition {

    private String name;
    private ElementType type;
    private List<ElementDefinition> fields = new ArrayList<>();
    private Map<String, PropertyType> properties = new HashMap<>();

    protected ElementDefinitionImpl(String name, ElementType type) {
        this(name, type, Collections.emptyList(), Collections.emptyMap());
    }

    protected ElementDefinitionImpl(String name, ElementType type, List<ElementDefinition> fields, Map<String, PropertyType> properties) {
        this.name = name;
        this.type = type;
        this.fields.addAll(fields);
        this.properties.putAll(properties);
    }

    ElementDefinitionImpl(ElementDefinition em) {
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
    public Map<String, PropertyType> getProperties() {
        return properties;
    }

    @Override
    public List<ElementDefinition> getFields() {
        return fields;
    }

}