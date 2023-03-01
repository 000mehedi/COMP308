
//Name: Md. Abdullah Mehedi Patwary
//ID: 3619873
//Email: mpatwary1@athabasca.edu
//Date: 07/11/2022

//To run this program:
//Open the whole PROGRAM2 folder into IntellIJ or Eclipse
//Run FullNameTest.java to check if it pass all the tests over FullName.java

public class FullName {
    //initializing the variables
    private final String title;
    private final String firstName;
    private final String middleName;
    private final String lastName;

    //Default Constructor, does not take any parameter and
    // supplies default values for the title, firstName, middleName, lastName
    public FullName(){
        this.title = "";
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
    }

    //Second constructor, takes four strings as parameters
    // corresponding to the title, firstName, middleName, lastName
    public FullName(String title, String firstName, String middleName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String toString(){
        String fullName = "";
        // adds title, firstName, middleName, lastName to the string fullName.
        if(title.length() > 0){
            fullName += title;
        }
        if(firstName.length() > 0){
            fullName += " " + firstName;
        }
        if(middleName.length() > 0){
            fullName += " " +  middleName;
        }
        if(lastName.length() > 0){
            fullName += " " + lastName;
        }
        //.trim() to remove unnecessary space between fullName
        return fullName.trim();
    }

}