package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.complex.AbstractComplexDefinition;
import dynservices.core.complex.ComplexDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kuleshov
 */
public interface RequestDefinition {

    List<ElementDefinition> getRequestParameters();

    ComplexDefinition getRequestBody();

}
