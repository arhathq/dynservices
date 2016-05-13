package dynservices.domain.types;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementType;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;

/**
 *
 */
public class AddressDefinition extends AbstractComplexDefinition {

    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String ZIP = "zip";

    public AddressDefinition() {
        super(BusinessType.ADDRESS.id());

        ArrayList<ElementDefinition> fields = new ArrayList<>();
        fields.add(ElementDefinitionBuilder.createFor(COUNTRY, ElementType.String).build());
        fields.add(ElementDefinitionBuilder.createFor(CITY, ElementType.String).build());
        fields.add(ElementDefinitionBuilder.createFor(STREET, ElementType.String).build());
        fields.add(ElementDefinitionBuilder.createFor(ZIP, ElementType.Integer).build());
        setFields(fields);
    }

}
