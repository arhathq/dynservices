package dynservices.domain.types;

import dynservices.core.ElementBuilder;
import dynservices.domain.Customer;
import dynservices.core.Element;
import dynservices.core.complex.AbstractComplexElement;
import dynservices.core.complex.ComplexType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class CustomerElement extends AbstractComplexElement<Customer> {

    private static final String CUSTOMER_NO = "customerNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Override
    public ComplexType getType() {
        return BusinessType.CUSTOMER;
    }

    @Override
    protected List<Element> fromValue(Customer customer) {
        List<Element> data = new ArrayList<>();

        data.add(ElementBuilder.createFor(CUSTOMER_NO, customer.getCustomerNo()).build());
        data.add(ElementBuilder.createFor(FIRST_NAME, customer.getFirstName()).build());
        data.add(ElementBuilder.createFor(LAST_NAME, customer.getLastName()).build());

        return data;
    }

    public static CustomerElement newCustomerData(Customer customer) {
        return newCustomerData(customer, Collections.emptyList());
    }

    public static CustomerElement newCustomerData(Customer customer, Element child) {
        return newCustomerData(customer, Collections.singletonList(child));
    }

    public static CustomerElement newCustomerData(Customer customer, List<Element> children) {
        CustomerElement data = new CustomerElement();
        data.setName(data.getType().id());
        data.setValue(customer);
        data.setChildren(children);
        return data;
    }
}