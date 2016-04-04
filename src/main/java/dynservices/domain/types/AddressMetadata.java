package dynservices.domain.types;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementType;
import dynservices.core.MetadataBuilder;
import dynservices.core.complex.AbstractComplexMetadata;

import java.util.ArrayList;

/**
 *
 */
public class AddressMetadata extends AbstractComplexMetadata {

    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String ZIP = "zip";

    public AddressMetadata() {
        super(BusinessType.ADDRESS.id());

        ArrayList<ElementMetadata> fields = new ArrayList<>();
        fields.add(MetadataBuilder.createFor(COUNTRY, ElementType.String).build());
        fields.add(MetadataBuilder.createFor(CITY, ElementType.String).build());
        fields.add(MetadataBuilder.createFor(STREET, ElementType.String).build());
        fields.add(MetadataBuilder.createFor(ZIP, ElementType.Integer).build());
        setFields(fields);
    }

}
