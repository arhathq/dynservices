package dynservices.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kuleshov
 */
public class ElementBuilder<T> {

    private String name;
    private T value;
    private List<Element> children = new ArrayList<>();

    private ElementBuilder(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public static <T> ElementBuilder<T> createFor(String name, T value) {
        return new ElementBuilder<T>(name, value);
    }

    public static <T> ElementBuilder<T> createFor(String name) {
        return createFor(name, null);
    }

    public ElementBuilder<T> withChildren(List<Element> children) {
        this.children.addAll(children);
        return this;
    }

    public ElementBuilder<T> withChild(Element<?> child) {
        children.add(new ElementImpl<>(child));
        return this;
    }

    public Element build() {
        checkForBuild();
        ElementImpl<T> data = new ElementImpl<>();
        data.setName(name);
        data.setValue(value);
        data.setChildren(children);

        clearAfterBuild();

        return data;
    }

    private void checkForBuild() {
        if (name == null) {
            throw new IllegalStateException("Element has been already built");
        }
    }

    private void clearAfterBuild() {
        name = null;
        value = null;
        children = null;
    }

    /**
     *
     */
    private static class ElementImpl<T> implements Element<T> {

        private String name;
        private T value;
        private List<Element> children  = new ArrayList<>();

        ElementImpl() {
        }

        ElementImpl(Element<T> data) {
            this.name = data.getName();
            this.value = data.getValue();
            this.children.addAll(data.getChildren());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public List<Element> getChildren() {
            return children;
        }

        public void setChildren(List<Element> children) {
            this.children = children;
        }

    }
}