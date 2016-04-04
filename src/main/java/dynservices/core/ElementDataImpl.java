package dynservices.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ElementDataImpl<T> implements ElementData<T> {

    private String name;
    private T value;
    private List<ElementData> children  = new ArrayList<>();

    ElementDataImpl() {
    }

    ElementDataImpl(ElementData<T> data) {
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

    public List<ElementData> getChildren() {
        return children;
    }

    public void setChildren(List<ElementData> children) {
        this.children = children;
    }

}
