package dynservices.core.complex;

import dynservices.core.ElementDefinition;
import dynservices.core.ElementType;
import dynservices.core.ElementDefinitionBuilder;
import dynservices.domain.types.AddressDefinition;
import dynservices.domain.types.CustomerDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class ComplexMetadataTest {

    @Test
    public void testBuildComplexMetadata() {
        ElementDefinition metadata = ElementDefinitionBuilder.createFor("service", ElementType.Container).
                withField(new CustomerDefinition()).
                withField(new AddressDefinition()).
                build();

        assertTrue(metadata.getFields().size() == 2);
    }

    @Test
    public void testBuildComplexMetadataWithNestedData() {
        ElementDefinition nestedMetadata = ElementDefinitionBuilder.createFor("service", ElementType.Container).
                withField(ElementDefinitionBuilder.createFor(new CustomerDefinition()).
                        withField(ElementDefinitionBuilder.createFor("addresses", ElementType.Container).
                                withField(new AddressDefinition())
                        )
                ).
                build();

        assertTrue(nestedMetadata.getFields().size() == 1);
    }

    @Test
    public void testModifyComplexMetadata() {
        CustomerDefinition cm = new CustomerDefinition();

        Set<String> originNames = new HashSet<>();
        originNames.addAll(cm.getFields().stream().map(ElementDefinition::getName).collect(Collectors.toList()));

        ComplexMetadataVisitor visitor = ComplexMetadataVisitor.newVisitor().addField("middleName", ElementType.String).removeField("lastName");
        cm.visit(visitor);

        assertTrue(cm.getFields().size() == 3);

        Set<String> modifiedNames = new HashSet<>();
        modifiedNames.addAll(cm.getFields().stream().map(ElementDefinition::getName).collect(Collectors.toList()));

        assertTrue(!originNames.equals(modifiedNames));
    }

}
