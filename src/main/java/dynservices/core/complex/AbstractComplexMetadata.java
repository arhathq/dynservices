package dynservices.core.complex;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class AbstractComplexMetadata implements ComplexMetadata {

    private String name;
    private ElementType type = ElementType.Custom;
    private Map<String, String> properties = new HashMap<>();
    private List<ElementMetadata> children;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public List<ElementMetadata> getChildren() {
        return children;
    }

    public void setChildren(List<ElementMetadata> children) {
        this.children = children;
    }

    @Override
    public ElementMetadata asElementMetadata() {
        return null; //todo: implement or remove method
    }
}
