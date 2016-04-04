package dynservices.domain.types;

import dynservices.core.DataBuilder;
import dynservices.domain.Address;
import dynservices.core.ElementData;
import dynservices.core.complex.AbstractComplexData;
import dynservices.core.complex.ComplexType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class AddressData extends AbstractComplexData<Address> {

    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String ZIP = "zip";

    @Override
    public ComplexType getType() {
        return BusinessType.ADDRESS;
    }

    @Override
    protected List<ElementData> fromValue(Address address) {
        List<ElementData> data = new ArrayList<>();

        data.add(DataBuilder.createFor(COUNTRY, address.getCountry()).build());
        data.add(DataBuilder.createFor(CITY, address.getCity()).build());
        data.add(DataBuilder.createFor(STREET, address.getStreet()).build());
        data.add(DataBuilder.createFor(ZIP, address.getZip()).build());

        return data;
    }

    public static AddressData newAddressData(Address address) {
        return newAddressData(address, Collections.emptyList());
    }

    public static AddressData newAddressData(Address address, ElementData child) {
        return newAddressData(address, Collections.singletonList(child));
    }

    public static AddressData newAddressData(Address address, List<ElementData> children) {
        AddressData data = new AddressData();
        data.setName(data.getType().id());
        data.setValue(address);
        data.setChildren(children);
        return data;
    }
}
