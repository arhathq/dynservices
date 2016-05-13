package dynservices.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ElementImpl<T> implements Element<T> {

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
