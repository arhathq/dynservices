package dynservices.core.schema;

import dynservices.core.PropertyType;

import java.util.Map;

/**
 *
 */
public interface SchemaDefinition {

    SchemaType getType();

    Map<String, PropertyType> getProperties();

    Map<SchemaType, SchemaDefinition[]> getFields();

}
