package dynservices.core;

import java.util.List;

/**
 *
 */
public interface ElementMetadata {

    String getName();

    ElementType getType();

    List<ElementMetadata> getChildren();

}