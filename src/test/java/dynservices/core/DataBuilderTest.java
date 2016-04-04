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
public class DataBuilderTest {
    @Test
    public void testBuildData() {
        ElementData addressData = DataBuilder.createFor("address").
                withChild(DataBuilder.createFor("country", "Ukraine").build()).
                withChild(DataBuilder.createFor("city", "Kyiv").build()).
                withChild(DataBuilder.createFor("street", "Lenina str.").build()).
                build();

        assertTrue(addressData.getName().equals("address"));
        assertTrue(addressData.getChildren().size() == 3);

        ElementData customerData = DataBuilder.createFor("customer").
                withChild(DataBuilder.createFor("firstName", "John").build()).
                withChild(DataBuilder.createFor("lastName", "Doe").build()).
                withChild(DataBuilder.createFor("addresses").withChild(addressData).build()).
                build();

        assertTrue(customerData.getChildren().size() == 3);
    }

    @Test
    public void testBuildDataTwice() {
        DataBuilder builder = DataBuilder.createFor("intValue", 1);
        builder.build();

        try {
            builder.build();
            fail("No exception was thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }
}