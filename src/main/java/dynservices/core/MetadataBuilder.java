package dynservices.core;

import dynservices.core.complex.ComplexMetadata;
import dynservices.core.complex.types.AddressMetadata;

import java.util.HashMap;

/**
 * Suitable class for generation of metadata. It is not a threadsafe
 */
public class MetadataBuilder {

    private ElementMetadata metadata;

    private ElementMetadata parent;
    private ElementMetadata current;

    private HashMap<Integer, ElementMetadata> parentMap;

    private MetadataBuilder() {}

    public static MetadataBuilder create() {
        return new MetadataBuilder();
    }

    public MetadataBuilder withRootElement(String name, ElementType type) {
        metadata = new ElementMetadataImpl(name, type);
        current = metadata;
        parent = metadata;
        parentMap = new HashMap<>();
        parentMap.put(current.hashCode(), parent);
        return this;
    }

    public MetadataBuilder withElement(String name, ElementType type) {
        checkForRoot();

        current = new ElementMetadataImpl(name, type);
        parentMap.put(current.hashCode(), parent);
        parent.getChildren().add(current);
        return this;
    }

    public MetadataBuilder withComplexElement(ComplexMetadata element) {
        checkForRoot();

        current = element;
        parentMap.put(current.hashCode(), parent);
        parent.getChildren().add(current);
        return this;
    }

    public MetadataBuilder withChildElements() {
        checkForRoot();

        parent = current;
        return this;
    }

    public MetadataBuilder withParent() {
        return withParent(1);
    }

    public MetadataBuilder withParent(int backstepNum) {
        checkForRoot();

        if (backstepNum <= 0) {
            throw new IllegalArgumentException("Value must be greater zero.");
        }

        for (int i = 0; i < backstepNum; i++) {
            current = parentMap.get(current.hashCode());
            parent = parentMap.get(current.hashCode());
        }
        return this;
    }

    public ElementMetadata build() {
        checkForRoot();

        current = null;
        parent = null;
        parentMap.clear();
        return metadata;
    }

    private void checkForRoot() {
        if (metadata == null) {
            throw new IllegalStateException("No root element defined");
        }
    }

    public static void main(String[] args) {
        ElementMetadata metadata = MetadataBuilder.create().
                withRootElement("service", ElementType.Container).
                withElement("customer", ElementType.Container).
                withChildElements().
                withElement("custNo", ElementType.String).
                withElement("firstName", ElementType.String).
                withElement("lastName", ElementType.String).
                withElement("birthDate", ElementType.Date).
                withElement("addresses", ElementType.Container).
                withChildElements().
                withElement("address", ElementType.Container).
                withChildElements().
                withElement("country", ElementType.String).
                withElement("city", ElementType.String).
                withParent().
                withComplexElement(new AddressMetadata()).
                build();

        System.out.println(metadata);
    }
}