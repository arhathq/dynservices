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
public class ComplexDefinitionTest {

    @Test
    public void testBuildComplexDefinition() {
        ElementDefinition elementDefinition = ElementDefinitionBuilder.createFor("service", ElementType.Container).
                withField(new CustomerDefinition()).
                withField(new AddressDefinition()).
                build();

        assertTrue(elementDefinition.getFields().size() == 2);
    }

    @Test
    public void testBuildComplexDefinitionWithNestedData() {
        ElementDefinition nestedDefinition = ElementDefinitionBuilder.createFor("service", ElementType.Container).
                withField(ElementDefinitionBuilder.createFor(new CustomerDefinition()).
                        withField(ElementDefinitionBuilder.createFor("addresses", ElementType.Container).
                                withField(new AddressDefinition())
                        )
                ).
                build();

        assertTrue(nestedDefinition.getFields().size() == 1);
    }

    @Test
    public void testModifyComplexDefinition() {
        CustomerDefinition cd = new CustomerDefinition();

        Set<String> originNames = new HashSet<>();
        originNames.addAll(cd.getFields().stream().map(ElementDefinition::getName).collect(Collectors.toList()));

        ComplexMetadataVisitor visitor = ComplexMetadataVisitor.newVisitor().addField("middleName", ElementType.String).removeField("lastName");
        cd.visit(visitor);

        assertTrue(cd.getFields().size() == 3);

        Set<String> modifiedNames = new HashSet<>();
        modifiedNames.addAll(cd.getFields().stream().map(ElementDefinition::getName).collect(Collectors.toList()));

        assertTrue(!originNames.equals(modifiedNames));
    }

}
