package dynservices.core.complex.types;

import dynservices.domain.Address;
import dynservices.core.DataMethods;
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

        data.add(DataMethods.newElementData(COUNTRY, address.getCountry()));
        data.add(DataMethods.newElementData(CITY, address.getCity()));
        data.add(DataMethods.newElementData(STREET, address.getStreet()));
        data.add(DataMethods.newElementData(ZIP, address.getZip()));

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
