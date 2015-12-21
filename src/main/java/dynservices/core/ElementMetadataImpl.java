package dynservices.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ElementMetadataImpl implements ElementMetadata {

    private String name;
    private ElementType type;
    private Map<String, String> properties = new HashMap<>();
    private List<ElementMetadata> children = new ArrayList<>();

    public ElementMetadataImpl(String name, ElementType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
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

}
