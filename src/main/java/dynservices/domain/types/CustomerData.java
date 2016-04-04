package dynservices.domain.types;

import dynservices.core.DataBuilder;
import dynservices.domain.Customer;
import dynservices.core.ElementData;
import dynservices.core.complex.AbstractComplexData;
import dynservices.core.complex.ComplexType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class CustomerData extends AbstractComplexData<Customer> {

    private static final String CUSTOMER_NO = "customerNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Override
    public ComplexType getType() {
        return BusinessType.CUSTOMER;
    }

    @Override
    protected List<ElementData> fromValue(Customer customer) {
        List<ElementData> data = new ArrayList<>();

        data.add(DataBuilder.createFor(CUSTOMER_NO, customer.getCustomerNo()).build());
        data.add(DataBuilder.createFor(FIRST_NAME, customer.getFirstName()).build());
        data.add(DataBuilder.createFor(LAST_NAME, customer.getLastName()).build());

        return data;
    }

    public static CustomerData newCustomerData(Customer customer) {
        return newCustomerData(customer, Collections.emptyList());
    }

    public static CustomerData newCustomerData(Customer customer, ElementData child) {
        return newCustomerData(customer, Collections.singletonList(child));
    }

    public static CustomerData newCustomerData(Customer customer, List<ElementData> children) {
        CustomerData data = new CustomerData();
        data.setName(data.getType().id());
        data.setValue(customer);
        data.setChildren(children);
        return data;
    }
}