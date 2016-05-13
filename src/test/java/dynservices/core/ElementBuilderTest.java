package dynservices.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Alexander Kuleshov
 */
@RunWith(JUnit4.class)
public class ElementBuilderTest {
    @Test
    public void testBuildData() {
        Element addressData = ElementBuilder.createFor("address").
                withChild(ElementBuilder.createFor("country", "Ukraine").build()).
                withChild(ElementBuilder.createFor("city", "Kyiv").build()).
                withChild(ElementBuilder.createFor("street", "Lenina str.").build()).
                build();

        assertTrue(addressData.getName().equals("address"));
        assertTrue(addressData.getChildren().size() == 3);

        Element customerData = ElementBuilder.createFor("customer").
                withChild(ElementBuilder.createFor("firstName", "John").build()).
                withChild(ElementBuilder.createFor("lastName", "Doe").build()).
                withChild(ElementBuilder.createFor("addresses").withChild(addressData).build()).
                build();

        assertTrue(customerData.getChildren().size() == 3);
    }

    @Test
    public void testBuildDataTwice() {
        ElementBuilder builder = ElementBuilder.createFor("intValue", 1);
        builder.build();

        try {
            builder.build();
            fail("No exception was thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }
}