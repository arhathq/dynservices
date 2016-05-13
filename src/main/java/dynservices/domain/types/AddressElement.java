package dynservices.domain.types;

import dynservices.core.ElementBuilder;
import dynservices.domain.Address;
import dynservices.core.Element;
import dynservices.core.complex.AbstractComplexElement;
import dynservices.core.complex.ComplexType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class AddressElement extends AbstractComplexElement<Address> {

    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String ZIP = "zip";

    @Override
    public ComplexType getType() {
        return BusinessType.ADDRESS;
    }

    @Override
    protected List<Element> fromValue(Address address) {
        List<Element> data = new ArrayList<>();

        data.add(ElementBuilder.createFor(COUNTRY, address.getCountry()).build());
        data.add(ElementBuilder.createFor(CITY, address.getCity()).build());
        data.add(ElementBuilder.createFor(STREET, address.getStreet()).build());
        data.add(ElementBuilder.createFor(ZIP, address.getZip()).build());

        return data;
    }

    public static AddressElement newAddressData(Address address) {
        return newAddressData(address, Collections.emptyList());
    }

    public static AddressElement newAddressData(Address address, Element child) {
        return newAddressData(address, Collections.singletonList(child));
    }

    public static AddressElement newAddressData(Address address, List<Element> children) {
        AddressElement data = new AddressElement();
        data.setName(data.getType().id());
        data.setValue(address);
        data.setChildren(children);
        return data;
    }
}
