//Name: Md. Abdullah Mehedi Patwary
//ID: 3619873
//Email: mpatwary1@athabasca.edu
//Date: 07/11/2022

//To run this program:
//Open the whole PROGRAM3 folder into IntellIJ or Eclipse
//Run Main.java to check if polymorphism works or not, if it prints two statements(then it works)

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();//initializing the object bicycle, deriving from Bicycle()

        bicycle.ride(); //prompts the print statement

        Tricycle tricycle = new Tricycle(); //initializing the object tricycle, deriving from Tricycle()
        tricycle.ride(); //prompts the print statement
    }
}