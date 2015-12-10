package dynservices.core;

import java.util.Collections;
import java.util.List;

/**
 *
 */
public class DataMethods {

    public static <T> ElementData<T> newElementData(String name, T value) {
        return newElementData(name, value, Collections.emptyList());
    }

    public static <T> ElementData<T> newElementData(String name, T value, ElementData child) {
        return newElementData(name, value, Collections.singletonList(child));
    }

    public static <T> ElementData<T> newElementData(String name, T value, List<ElementData> children) {
        ElementDataImpl<T> data = new ElementDataImpl<>();
        data.setName(name);
        data.setValue(value);
        data.setChildren(children);
        return data;
    }

}
