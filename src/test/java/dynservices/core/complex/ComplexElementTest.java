package dynservices.core.complex;

import dynservices.core.ElementBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import dynservices.core.Element;
import dynservices.domain.Address;
import dynservices.domain.types.AddressElement;
import dynservices.domain.Customer;
import dynservices.domain.types.CustomerElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ComplexElementTest {

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
        ComplexElement<Address> addressData = AddressElement.newAddressData(address);

        Element element = addressData.asElementData();
        assertTrue(element.getName().equals(addressData.getType().id()));
        assertFalse(element.getChildren().isEmpty());
        assertTrue(element.getChildren().size() == 4);
    }

    @Test
    public void testCreateCustomerData() {
        List<Element> customsChildren = new ArrayList<>();
        customsChildren.add(ElementBuilder.createFor("optional1", "23").build());

        Customer customer1 = new Customer();
        customer1.setCustomerNo("2233ZXX");
        customer1.setFirstName("Jane");
        customer1.setLastName("Rose");
        customsChildren.add(CustomerElement.newCustomerData(customer1));

        customsChildren.add(ElementBuilder.createFor("optional2", "2222").build());

        Element customsData = ElementBuilder.createFor("customs", customsChildren).build();

        ComplexElement<Address> addressData = AddressElement.newAddressData(address, customsData);

        Element addressesData = ElementBuilder.createFor("addresses", addressData).build();

        ComplexElement<Customer> customerData = CustomerElement.newCustomerData(customer, addressesData);

        Element element = customerData.asElementData();
        assertTrue(element.getName().equals(customerData.getType().id()));
    }
}
