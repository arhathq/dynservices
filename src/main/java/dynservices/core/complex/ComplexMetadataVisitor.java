package dynservices.core.complex;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ComplexMetadataVisitor {

    private List<VisitorOperation> operations = new ArrayList<>();

    private ComplexMetadataVisitor() {}

    public static ComplexMetadataVisitor newVisitor() {
        return new ComplexMetadataVisitor();
    }


    public void visit(List<ElementMetadata> fields) {
        operations.stream().forEach(action -> action.toString());
    }

    public ComplexMetadataVisitor addField(String name, ElementType type) {
        operations.add(VisitorOperation.ADD);
        return this;
    }

    public ComplexMetadataVisitor removeField(String name) {
        operations.add(VisitorOperation.REMOVE);
        return this;
    }


    private enum VisitorOperation {
        ADD, REMOVE
    }
/*
    public void addField(String name, ElementType type) {
        fields.add(new ElementMetadataImpl(name, type));
    }

    public void removeField(String name) {
        fields.stream().filter(field -> field.getName().equals(name)).forEach(field -> {
            fields.remove(field);
        });
    }
*/
}
