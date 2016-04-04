package dynservices.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kuleshov
 */
public class DataBuilder<T> {

    private String name;
    private T value;
    private List<ElementData> children = new ArrayList<>();

    private DataBuilder(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public static <T> DataBuilder<T> createFor(String name, T value) {
        return new DataBuilder<T>(name, value);
    }

    public static <T> DataBuilder<T> createFor(String name) {
        return createFor(name, null);
    }

    public DataBuilder<T> withChildren(List<ElementData> children) {
        this.children.addAll(children);
        return this;
    }

    public DataBuilder<T> withChild(ElementData<?> child) {
        children.add(new ElementDataImpl<>(child));
        return this;
    }

    public ElementData build() {
        checkForBuild();
        ElementDataImpl<T> data = new ElementDataImpl<>();
        data.setName(name);
        data.setValue(value);
        data.setChildren(children);

        clearAfterBuild();

        return data;
    }

    private void checkForBuild() {
        if (name == null) {
            throw new IllegalStateException("Data has been already built");
        }
    }

    private void clearAfterBuild() {
        name = null;
        value = null;
        children = null;
    }

}