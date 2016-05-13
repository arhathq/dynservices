package dynservices.core;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ElementDefinition {

    String getName();

    ElementType getType();

    Map<String, String> getProperties();

    List<ElementDefinition> getFields();

}