package dynservices.core.complex;

import dynservices.core.ElementMetadata;

/**
 *
 */
public interface ComplexMetadata extends ElementMetadata {

    ComplexMetadata visit(ComplexMetadataVisitor visitor);

    ElementMetadata asElementMetadata();

}
