import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ShippingLabelTest {
    @Test
    public void defaultConstructor() {
        ShippingLabel label = new ShippingLabel();
        assertTrue(true);
    }

    @Test
    public void mainConstructor() {
        MailingAddress fromMailingAddress = new MailingAddress();

        FullName fullName = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        MailingAddress toMailingAddress = new MailingAddress(fullName, "1 University Dr,", "Athabasca", "AB", "T9S 3A3");

        ShippingLabel label = new ShippingLabel(fromMailingAddress, toMailingAddress);
        assertTrue(true);
    }

    @Test
    public void labelToString() {

        MailingAddress fromMailingAddress = new MailingAddress();

        FullName fullName = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        MailingAddress toMailingAddress = new MailingAddress(fullName, "1 University Dr,", "Athabasca", "AB", "T9S 3A3");

        ShippingLabel label = new ShippingLabel(fromMailingAddress, toMailingAddress);
        //checks if fullName and toMailingAddress is combinedly equal to label or not
        assertEquals("Md. Abdullah Mehedi Patwary\n1 University Dr,\nAthabasca, AB T9S 3A3", label.toString());
    }
}