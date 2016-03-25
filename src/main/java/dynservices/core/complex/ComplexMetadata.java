package dynservices.core.complex;

import dynservices.core.ElementMetadata;

/**
 *
 */
public interface ComplexMetadata extends ElementMetadata {

    void addField(ElementMetadata em);

    void removeField(ElementMetadata em);

    ElementMetadata asElementMetadata();

}
