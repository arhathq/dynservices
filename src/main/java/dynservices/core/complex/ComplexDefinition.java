package dynservices.core.complex;

import dynservices.core.ElementDefinition;

/**
 *
 */
public interface ComplexDefinition extends ElementDefinition {

    ComplexDefinition visit(ComplexMetadataVisitor visitor);

    ElementDefinition asElementMetadata();

}
