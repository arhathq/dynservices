package dynservices.core.types.metatypes;

import java.util.List;


/**
 * @author Alexander Kuleshov
 */
public class ContainerDefinition implements ElementDefinition {

    private String name;
    private List<ElementDefinition> elements;

    private ContainerDefinition(String name, List<ElementDefinition> elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<ElementDefinition> getElements() {
        return elements;
    }
}