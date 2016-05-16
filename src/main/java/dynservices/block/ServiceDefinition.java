package dynservices.block;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.core.ElementType;
import dynservices.core.PropertyType;
import dynservices.core.complex.AbstractComplexDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ServiceDefinition extends AbstractComplexDefinition {

    public ServiceDefinition() {
        super(BlockType.SERVICE.id());

        ArrayList<ElementDefinition> fields = new ArrayList<>();
        fields.add(ElementDefinitionBuilder.createFor(BlockType.REQUEST.id(), ElementType.Custom).build());
        fields.add(ElementDefinitionBuilder.createFor(BlockType.RESPONSE.id(), ElementType.Custom).build());
        fields.add(ElementDefinitionBuilder.createFor(BlockType.ACTION.id(), ElementType.Custom).build());
        fields.add(ElementDefinitionBuilder.createFor(BlockType.ERROR.id(), ElementType.Custom).build());
        setFields(fields);

        HashMap<String, PropertyType> properties = new HashMap<>();
        properties.put("name", PropertyType.String);
        properties.put("version", PropertyType.String);
        setProperties(properties);

    }

//    String getName();
//
//    String getVersion();
//
//    Map<String, String> getProperties();
//
//    RequestDefinition getRequestDefinition();
//
//    List<ActionDefinition> getActionsDefinitions();
//
//    ResponseDefinition getResponseDefinition();
//
//    ErrorDefinition getErrorDefinition();

}