
//Name: Md. Abdullah Mehedi Patwary
//ID: 3619873
//Email: mpatwary1@athabasca.edu
//Date: 07/11/2022

//To run this program:
    //Open the whole PROGRAM1 folder into IntellIJ or Eclipse
    //Run CircleTest.java to check if it pass all the tests over Circle.java


public class Circle {

    //initializing the variables
    private double x;
    private double y;
    private double radius;
    private double MAXIMUM_RADIUS = 50;


    //Default Constructor, does not take any parameter and
    // supplies default values for the coordinates and the radius
    public Circle() {
        this.x = 0;
        this.y = 0;

        this.setRadius(6);
    }


    //Second constructor, takes three doubles as parameters
    // corresponding to the X and Y coordinates and the radius.
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.setRadius(radius);
    }


    // Circumference
    public double circumference() {
        return 2 * Math.PI * radius;
    }


    //Area. Math.PI refers to the value or pi = 3.1416.....
    public double area() {
        return Math.PI * radius * radius;
    }


    // checks radius against the MAXIMUM_RADIUS. Math.min() returns the minimum value between r and MAXIMUM_RADIUS.
    public void setRadius(double r) {
        this.radius = Math.min(r, MAXIMUM_RADIUS);
    }


    //prints the coordinates, the radius, the circumference, and the area
    public void printAttributes() {
        System.out.printf("Coordinates: (%.0f, %.0f)\n", x, y);

        System.out.printf("Radius: %.2f\n", radius);

        System.out.printf("Circumference: %.2f\n", circumference());

        System.out.printf("Area: %.2f\n", area());
    }

    //Math.hypot() refers to the root of squares of the differences of x(s)
    public boolean isInside(double x, double y) {
        if (Math.hypot(this.x - x, this.y - y) <= radius) {
            return true;
        } else {
            return false;
        }
    }

    //moves the origin by a specified amount
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }


}