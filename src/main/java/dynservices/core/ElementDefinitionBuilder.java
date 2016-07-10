package dynservices.core;


import java.util.*;

/**
 * Suitable class for generation of metadata. It is not a thread safe
 */
public class ElementDefinitionBuilder {

    private String name;
    private ElementType type;
    private List<ElementDefinition> fields = new ArrayList<>();
    private Map<String, PropertyType> properties = new HashMap<>();

    private ElementDefinitionBuilder(String name, ElementType type) {
        checkForName(name);
        this.name = name;
        this.type = type;
    }

    private ElementDefinitionBuilder(ElementDefinition em) {
        this.name = em.getName();
        this.type = em.getType();
        fields.addAll(em.getFields());
    }

    public static ElementDefinitionBuilder createFor(String name, ElementType type) {
        return new ElementDefinitionBuilder(name, type);
    }

    public static ElementDefinitionBuilder createFor(ElementDefinition em) {
        return new ElementDefinitionBuilder(em);
    }

    public ElementDefinitionBuilder withField(String name, ElementType type) {
        checkForName(name);
        fields.add(new ElementDefinitionImpl(name, type));
        return this;
    }

    public ElementDefinitionBuilder withField(ElementDefinition em) {
        fields.add(em);
        return this;
    }

    public ElementDefinitionBuilder withField(ElementDefinitionBuilder builder) {
        fields.add(builder.build());
        return this;
    }

    public ElementDefinitionBuilder withProperties(Map<String, PropertyType> properties) {
        this.properties.putAll(properties);
        return this;
    }

    public ElementDefinitionBuilder withProperty(String name, PropertyType type) {
        properties.put(name, type);
        return this;
    }

    public ElementDefinition build() {
        checkForBuild();
        ElementDefinition em = new ElementDefinitionImpl(name, type, fields, properties);
        clearAfterBuild();
        return em;
    }

    private void checkForBuild() {
        if (name == null) {
            throw new IllegalStateException("ElementDefinition has been already built");
        }
    }

    private void checkForName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalStateException("No name defined");
        }
    }

    private void clearAfterBuild() {
        name = null;
        type = null;
        fields = null;
        properties = null;
    }

    /**
     *
     */
    private static class ElementDefinitionImpl implements ElementDefinition {

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
}