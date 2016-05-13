package dynservices.core.complex;

import dynservices.core.ElementBuilder;
import dynservices.core.Element;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class AbstractComplexElement<T> implements ComplexElement<T> {

    private String name;
    private T value;
    private List<Element> children;

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
    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    @Override
    public Element asElementData() {
        if (getValue() == null) {
            return ElementBuilder.createFor(getType().id()).build();
        }

        List<Element> children = new ArrayList<>();
        children.addAll(fromValue(getValue()));
        for (Element child : getChildren()) {
            if (child instanceof ComplexElement) {
                children.add(((ComplexElement) child).asElementData());
            } else {
                children.add(resolveElementData(child));
            }
        }

        return ElementBuilder.createFor(getType().id()).withChildren(children).build();
    }

    protected Element resolveElementData(Element<?> element) {
        List<Element> resolvedChildren = new ArrayList<>();
        for (Element child : element.getChildren()) {
            if (child instanceof ComplexElement) {
                resolvedChildren.add(((ComplexElement) child).asElementData());
            } else {
                resolvedChildren.add(resolveElementData(child));
            }
        }

        return ElementBuilder.createFor(element.getName(), element.getValue()).withChildren(resolvedChildren).build();
    }

    protected abstract List<Element> fromValue(T value);
}