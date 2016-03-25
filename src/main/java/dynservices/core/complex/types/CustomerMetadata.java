package dynservices.core.complex.types;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementMetadataImpl;
import dynservices.core.ElementType;
import dynservices.core.complex.AbstractComplexMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kuleshov
 */
public class CustomerMetadata extends AbstractComplexMetadata {

    private static final String CUSTOMER_NO = "customerNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    public CustomerMetadata() {
        super(BusinessType.CUSTOMER.id());

        List<ElementMetadata> fields = new ArrayList<>();
        fields.add(new ElementMetadataImpl(CUSTOMER_NO, ElementType.String));
        fields.add(new ElementMetadataImpl(FIRST_NAME, ElementType.String));
        fields.add(new ElementMetadataImpl(LAST_NAME, ElementType.String));
        setFields(fields);
    }

}
