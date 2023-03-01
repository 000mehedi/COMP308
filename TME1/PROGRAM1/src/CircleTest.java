import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.testng.Assert.*;

public class CircleTest {
    @Test
    public void defaultConstructor() {
        Circle circle = new Circle();
        assertTrue(true);
    }

    @Test
    public void mainConstructor() {
        Circle circle = new Circle(10, 10, 15);
        assertTrue(true);
    }

    @Test
    //Checks if the circumference is correct
    public void correctCircumference() {
        Circle circle = new Circle(0, 0, 10);
        assertEquals(62.83, circle.circumference(), 0.01);
    }

    @Test
    //Checks if the area is correct
    public void correctArea() {
        Circle circle = new Circle(0, 0, 10);
        assertEquals(314.16, circle.area(), 0.01);
    }

    @Test
    public void correctlySetRadius() throws NoSuchFieldException, IllegalAccessException {
        Circle circle = new Circle(0, 0, 5);
        circle.setRadius(20);

        final Field field = circle.getClass().getDeclaredField("radius");
        field.setAccessible(true);
        assertEquals(20, field.getDouble(circle));
    }

    @Test
    public void correctlyLimitRadius() throws NoSuchFieldException, IllegalAccessException {
        Circle circle = new Circle(0, 0, 5);
        circle.setRadius(55);

        final Field field = circle.getClass().getDeclaredField("radius");
        field.setAccessible(true);
        assertEquals(50, field.getDouble(circle));
    }

    @Test
    //checks if x, y and radius input are equal to the print statement or not
    public void correctlyPrintAttributes() {
        ByteArrayOutputStream sysOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sysOut));

        Circle circle = new Circle(0, 0, 10);
        circle.printAttributes();
        assertEquals("Coordinates: (0, 0)\nRadius: 10.00\nCircumference: 62.83\nArea: 314.16\n", sysOut.toString());
    }

    @Test
    //checks if the points are inside the circle or not
    public void testIsInside() {
        Circle circle = new Circle(0, 0, 5);
        assertTrue(circle.isInside(4, 3));
    }

    @Test
    //Otherwise
    public void testIsNotInside() {
        Circle circle = new Circle(0, 0, 5);
        assertFalse(circle.isInside(12, 5));
    }

    @Test
    //checks if the given x and y adds with the Circle's x and y coordinates or not
    public void testMove() throws NoSuchFieldException, IllegalAccessException {
        Circle circle = new Circle(0, 0, 5);
        circle.move(10, 10);

        final Field fieldX = circle.getClass().getDeclaredField("x");
        fieldX.setAccessible(true);
        final Field fieldY = circle.getClass().getDeclaredField("y");
        fieldY.setAccessible(true);

        assertEquals(10, fieldX.getDouble(circle) );
        assertEquals(10, fieldY.getDouble(circle));

        circle.move(2, 2);
        assertEquals(12, fieldX.getDouble(circle));
        assertEquals(12, fieldY.getDouble(circle));
    }
}