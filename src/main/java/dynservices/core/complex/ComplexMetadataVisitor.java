package dynservices.core.complex;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementType;
import dynservices.core.MetadataBuilder;

import java.util.*;

/**
 *
 */
public class ComplexMetadataVisitor {

    private static final String OPERATION = "OPERATION";
    private static final String FIELD = "FIELD";
    private static final String TYPE = "TYPE";

    private List<Map<String, Object>> operations = new ArrayList<>();

    private ComplexMetadataVisitor() {}

    public static ComplexMetadataVisitor newVisitor() {
        return new ComplexMetadataVisitor();
    }


    void visit(List<ElementMetadata> fields) {
        Iterator<Map<String, Object>> it = operations.iterator();
        while (it.hasNext()) {
            Map<String, Object> data = it.next();
            VisitorOperation operation = (VisitorOperation) data.remove(OPERATION);
            operation.execute(fields, data);
            it.remove();
        }
    }

    public ComplexMetadataVisitor addField(String name, ElementType type) {
        Map<String, Object> data = new HashMap<>();
        data.put(OPERATION, VisitorOperation.ADD);
        data.put(FIELD, name);
        data.put(TYPE, type);
        operations.add(data);
        return this;
    }

    public ComplexMetadataVisitor removeField(String name) {
        Map<String, Object> data = new HashMap<>();
        data.put(OPERATION, VisitorOperation.REMOVE);
        data.put(FIELD, name);
        operations.add(data);
        return this;
    }

    private enum VisitorOperation {

        ADD {
            @Override
            public void execute(List<ElementMetadata> fields, Map<String, Object> data) {
                String field = (String) data.get(FIELD);
                ElementType type = (ElementType) data.get(TYPE);
                fields.add(MetadataBuilder.createFor(field, type).build());
            }
        },

        REMOVE {
            @Override
            public void execute(List<ElementMetadata> fields, Map<String, Object> data) {
                String name = (String) data.get(FIELD);
                Iterator<ElementMetadata> it = fields.iterator();
                while (it.hasNext()) {
                    ElementMetadata field = it.next();
                    if (field.getName().equals(name)) {
                        it.remove();
                    }
                }
            }
        };

        public abstract void execute(List<ElementMetadata> fields, Map<String, Object> data);
    }
}