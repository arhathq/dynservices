package dynservices.core.schema;

import dynservices.core.PropertyType;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class SchemaDefinitionBuilder {

    private SchemaType type;
    private Map<SchemaType, SchemaDefinition[]> fields = new HashMap<>();
    private Map<String, PropertyType> properties = new HashMap<>();

    private SchemaDefinitionBuilder(SchemaType type) {
        this.type = type;
    }

    private SchemaDefinitionBuilder(SchemaDefinition em) {
        this.type = em.getType();
        properties.putAll(em.getProperties());
        fields.putAll(em.getFields());
    }

    public static SchemaDefinitionBuilder createFor(SchemaType type) {
        return new SchemaDefinitionBuilder(type);
    }

    public static SchemaDefinitionBuilder createFor(SchemaDefinition definition) {
        return new SchemaDefinitionBuilder(definition);
    }

    protected SchemaDefinitionBuilder withField(SchemaType type, Map<String, PropertyType> properties, Map<SchemaType, SchemaDefinition[]> fields) {
        fields.put(type, add(field(type), new SchemaDefinitionImpl(type, properties, fields)));
        return this;
    }

    public SchemaDefinitionBuilder withField(SchemaDefinition definition) {
        fields.put(definition.getType(), add(field(definition.getType()), new SchemaDefinitionImpl(definition)));
        return this;
    }


    public SchemaDefinitionBuilder withField(SchemaDefinitionBuilder builder) {
        SchemaDefinition definition = builder.build();
        fields.put(definition.getType(), add(field(definition.getType()), definition));
        return this;
    }

    public SchemaDefinitionBuilder withProperties(Map<String, PropertyType> properties) {
        this.properties.putAll(properties);
        return this;
    }

    public SchemaDefinitionBuilder withProperty(String name, PropertyType type) {
        properties.put(name, type);
        return this;
    }

    public SchemaDefinition build() {
        checkForBuild();
        SchemaDefinition em = new SchemaDefinitionImpl(type, properties, fields);
        clearAfterBuild();
        return em;
    }

    private SchemaDefinition[] field(SchemaType type) {
        return fields.getOrDefault(type, new SchemaDefinition[0]);
    }

    private SchemaDefinition[] add(SchemaDefinition[] oldArr, SchemaDefinition el) {
        SchemaDefinition[] newArr = new SchemaDefinition[oldArr.length + 1];

        System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
        newArr[newArr.length - 1] = el;

        return newArr;
    }

    private void checkForBuild() {
        if (type == null) {
            throw new IllegalStateException("SchemaDefinition has been already built");
        }
    }

    private static void checkForType(SchemaDefinition definition, SchemaType type) {
        if (definition == null) {
            throw new IllegalArgumentException("SchemaDefinition is null");
        } else if (definition.getType() == null) {
            throw new IllegalArgumentException("SchemaDefinition contains type that is null");
        } else if (definition.getType().equals(type)) {
            throw new IllegalArgumentException("SchemaDefinition contains invalid type: " + definition.getType());
        }
    }

    private void clearAfterBuild() {
        type = null;
        fields = null;
        properties = null;
    }

    /**
     *
     */
    private static class SchemaDefinitionImpl implements SchemaDefinition {

        private final SchemaType type;
        private final Map<String, PropertyType> properties = new HashMap<>();
        private final Map<SchemaType, SchemaDefinition[]> fields = new HashMap<>();

        SchemaDefinitionImpl(SchemaType type, Map<String, PropertyType> properties, Map<SchemaType, SchemaDefinition[]> fields) {
            this.type = type;
            this.properties.putAll(properties);
            this.fields.putAll(fields);
        }

        SchemaDefinitionImpl(SchemaDefinition schemaDefinition) {
            this.type = schemaDefinition.getType();
            this.properties.putAll(schemaDefinition.getProperties());
            this.fields.putAll(schemaDefinition.getFields());
        }

        @Override
        public SchemaType getType() {
            return type;
        }

        @Override
        public Map<String, PropertyType> getProperties() {
            return properties;
        }

        @Override
        public Map<SchemaType, SchemaDefinition[]> getFields() {
            return fields;
        }
    }
}
