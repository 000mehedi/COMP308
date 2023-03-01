import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MailingAddressTest {
    @Test
    public void defaultConstructor() {
        MailingAddress address = new MailingAddress();
        assertTrue(true);
    }

    @Test
    public void mainConstructor() {
        FullName fullName = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        MailingAddress fullNameWithAddress = new MailingAddress(fullName, "1 University Dr,", "Athabasca", "AB", "T9S 3A3");
        assertTrue(true);
    }

    @Test
    // checks if the fullName and address is equal to fullNameWithAddress or not
    public void fullNameWithAddressToString() {
        FullName fullName = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        MailingAddress fullNameWithAddress = new MailingAddress(fullName, "1 University Dr,", "Athabasca", "AB", "T9S 3A3");
        assertEquals("Md. Abdullah Mehedi Patwary\n1 University Dr,\nAthabasca, AB T9S 3A3", fullNameWithAddress.toString());
    }
}