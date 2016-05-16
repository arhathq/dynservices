package dynservices.core;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ElementDefinition {

    String getName();

    ElementType getType();

    Map<String, PropertyType> getProperties();

    List<ElementDefinition> getFields();

}