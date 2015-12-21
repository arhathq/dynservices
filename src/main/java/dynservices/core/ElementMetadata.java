package dynservices.core;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ElementMetadata {

    String getName();

    ElementType getType();

    Map<String, String> getProperties();

    List<ElementMetadata> getChildren();

}