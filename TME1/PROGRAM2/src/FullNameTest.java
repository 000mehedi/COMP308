
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class FullNameTest {
    @Test
    public void defaultConstructor() {
        FullName name = new FullName();
        assertTrue(true);
    }

    @Test
    public void mainConstructor() {
        FullName name = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        assertTrue(true);
    }

    @Test
    //checks if the fullName is equal or not
    public void fullToString() {
        FullName name = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        assertEquals("Md. Abdullah Mehedi Patwary", name.toString());
    }

    @Test
    //cases where there is no title
    public void noTitleToString() {
        FullName name = new FullName("", "Abdullah", "Mehedi", "Patwary");
        assertEquals("Abdullah Mehedi Patwary", name.toString());
    }

    @Test
    //cases where there is no firstName
    public void noFirstNameToString() {
        FullName name = new FullName("Md.", "", "Mehedi", "Patwary");
        assertEquals("Md. Mehedi Patwary", name.toString());
    }

    @Test
    //cases where there is no middleName
    public void noMiddleNameToString() {
        FullName name = new FullName("Md.", "Abdullah", "", "Patwary");
        assertEquals("Md. Abdullah Patwary", name.toString());
    }

    @Test
    //cases where there is no lastName
    public void noLastNameToString() {
        FullName name = new FullName("Md.", "Abdullah", "Mehedi", "");
        assertEquals("Md. Abdullah Mehedi", name.toString());
    }
}