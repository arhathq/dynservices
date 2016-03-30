package dynservices.core;

import java.util.List;

/**
 *
 */
public class ElementDataImpl<T> implements ElementData<T> {

    private String name;
    private T value;
    private List<ElementData> children;

    protected ElementDataImpl() {
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
