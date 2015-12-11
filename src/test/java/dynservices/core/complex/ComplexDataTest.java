package dynservices.core.complex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import dynservices.core.DataMethods;
import dynservices.core.ElementData;
import dynservices.domain.Address;
import dynservices.core.complex.types.AddressData;
import dynservices.domain.Customer;
import dynservices.core.complex.types.CustomerData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ComplexDataTest {

    private Address address;
    private Customer customer;

    @Before
    public void setUp() {
        address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Donetsk");
        address.setStreet("Lenina street");
        address.setZip(84300);

        customer = new Customer();
        customer.setCustomerNo("1");
        customer.setFirstName("John");
        customer.setLastName("Doe");
    }

    @Test
    public void testCreateAddressData() {
        ComplexData<Address> addressData = AddressData.newAddressData(address);

        ElementData elementData = addressData.asElementData();
        assertTrue(elementData.getName().equals(addressData.getType().id()));
        assertFalse(elementData.getChildren().isEmpty());
        assertTrue(elementData.getChildren().size() == 4);
    }

    @Test
    public void testCreateCustomerData() {
        List<ElementData> customsChildren = new ArrayList<>();
        customsChildren.add(DataMethods.newElementData("optional1", "23"));

        Customer customer1 = new Customer();
        customer1.setCustomerNo("2233ZXX");
        customer1.setFirstName("Jane");
        customer1.setLastName("Rose");
        customsChildren.add(CustomerData.newCustomerData(customer1));

        customsChildren.add(DataMethods.newElementData("optional2", "2222"));

        ElementData customsData = DataMethods.newElementData("customs", null, customsChildren);

        ComplexData<Address> addressData = AddressData.newAddressData(address, customsData);

        ElementData addressesData = DataMethods.newElementData("addresses", null, addressData);

        ComplexData<Customer> customerData = CustomerData.newCustomerData(customer, addressesData);

        ElementData elementData = customerData.asElementData();
        assertTrue(elementData.getName().equals(customerData.getType().id()));
    }
}
