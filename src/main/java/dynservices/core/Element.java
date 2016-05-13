package dynservices.core;

import java.util.List;

/**
 *
 */
public interface Element<T> {

    String getName();

    T getValue();

    List<Element> getChildren();

}
