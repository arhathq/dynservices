package dynservices.core;

import java.util.List;

/**
 *
 */
public interface ElementData<T> {

    String getName();

    T getValue();

    List<ElementData> getChildren();

}
