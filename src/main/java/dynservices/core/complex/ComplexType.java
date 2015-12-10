package dynservices.core.complex;

/**
 * Marker for complex types
 */
public enum ComplexType {

    ADDRESS("address"),
    CUSTOMER("customer");

    private final String id;

    ComplexType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}