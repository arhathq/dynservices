package dynservices.block;

import dynservices.core.ElementDefinition;

import java.util.List;

/**
 * @author Alexander Kuleshov
 */
public interface ActionDefinition {

    List<ElementDefinition> getInputParameters();

    List<ElementDefinition> getOutputParameters();

}
