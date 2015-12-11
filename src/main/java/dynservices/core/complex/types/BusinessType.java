package dynservices.core.complex.types;

import dynservices.core.complex.ComplexType;

/**
 * @author Alexander Kuleshov
 */
public enum BusinessType implements ComplexType {

    ADDRESS("address"),
    CUSTOMER("customer");

    private final String id;

    BusinessType(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }

}
