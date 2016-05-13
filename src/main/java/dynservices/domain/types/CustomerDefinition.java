package dynservices.domain.types;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementType;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;

/**
 * @author Alexander Kuleshov
 */
public class CustomerDefinition extends AbstractComplexDefinition {

    private static final String CUSTOMER_NO = "customerNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    public CustomerDefinition() {
        super(BusinessType.CUSTOMER.id());

        ArrayList<ElementDefinition> fields = new ArrayList<>();
        fields.add(ElementDefinitionBuilder.createFor(CUSTOMER_NO, ElementType.String).build());
        fields.add(ElementDefinitionBuilder.createFor(FIRST_NAME, ElementType.String).build());
        fields.add(ElementDefinitionBuilder.createFor(LAST_NAME, ElementType.String).build());
        setFields(fields);
    }

}
