package dynservices.core.complex.types;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementType;
import dynservices.core.MetadataBuilder;
import dynservices.core.complex.AbstractComplexMetadata;

import java.util.ArrayList;

/**
 * @author Alexander Kuleshov
 */
public class CustomerMetadata extends AbstractComplexMetadata {

    private static final String CUSTOMER_NO = "customerNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    public CustomerMetadata() {
        super(BusinessType.CUSTOMER.id());

        ArrayList<ElementMetadata> fields = new ArrayList<>();
        fields.add(MetadataBuilder.createFor(CUSTOMER_NO, ElementType.String).build());
        fields.add(MetadataBuilder.createFor(FIRST_NAME, ElementType.String).build());
        fields.add(MetadataBuilder.createFor(LAST_NAME, ElementType.String).build());
        setFields(fields);
    }

}
