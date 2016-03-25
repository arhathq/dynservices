package dynservices.core.complex.types;

import dynservices.core.ElementMetadata;
import dynservices.core.ElementMetadataImpl;
import dynservices.core.ElementType;
import dynservices.core.complex.AbstractComplexMetadata;

import java.util.ArrayList;
import java.util.List;

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

        List<ElementMetadata> fields = new ArrayList<>();
        fields.add(new ElementMetadataImpl(COUNTRY, ElementType.String));
        fields.add(new ElementMetadataImpl(CITY, ElementType.String));
        fields.add(new ElementMetadataImpl(STREET, ElementType.String));
        fields.add(new ElementMetadataImpl(ZIP, ElementType.Integer));
        setFields(fields);
    }

}
