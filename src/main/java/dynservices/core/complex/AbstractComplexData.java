package dynservices.core.complex;

import dynservices.core.DataBuilder;
import dynservices.core.ElementData;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class AbstractComplexData<T> implements ComplexData<T> {

    private String name;
    private T value;
    private List<ElementData> children;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public List<ElementData> getChildren() {
        return children;
    }

    public void setChildren(List<ElementData> children) {
        this.children = children;
    }

    @Override
    public ElementData asElementData() {
        if (getValue() == null) {
            return DataBuilder.createFor(getType().id()).build();
        }

        List<ElementData> children = new ArrayList<>();
        children.addAll(fromValue(getValue()));
        for (ElementData child : getChildren()) {
            if (child instanceof ComplexData) {
                children.add(((ComplexData) child).asElementData());
            } else {
                children.add(resolveElementData(child));
            }
        }

        return DataBuilder.createFor(getType().id()).withChildren(children).build();
    }

    protected ElementData resolveElementData(ElementData<?> elementData) {
        List<ElementData> resolvedChildren = new ArrayList<>();
        for (ElementData child : elementData.getChildren()) {
            if (child instanceof ComplexData) {
                resolvedChildren.add(((ComplexData) child).asElementData());
            } else {
                resolvedChildren.add(resolveElementData(child));
            }
        }

        return DataBuilder.createFor(elementData.getName(), elementData.getValue()).withChildren(resolvedChildren).build();
    }

    protected abstract List<ElementData> fromValue(T value);
}