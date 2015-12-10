package dynservices.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ElementMetadataImpl implements ElementMetadata {

    private String name;
    private ElementType type;
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
    public List<ElementMetadata> getChildren() {
        return children;
    }

    public void setChildren(List<ElementMetadata> children) {
        this.children = children;
    }

}
