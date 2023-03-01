//Name: Md. Abdullah Mehedi Patwary
//ID: 3619873
//Email: mpatwary1@athabasca.edu
//Date: 07/11/2022

//To run this program:
//Open the whole PROGRAM2 folder into IntellIJ or Eclipse
//Run MailingAddressTest.java to check if it pass all the tests over MailingAddress.java


public class MailingAddress {
    //initializing the variables
    private FullName fullName;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    public MailingAddress(){
        //Default Constructor, does not take any parameter and
        // supplies default values for the streetAddress, city, province, postalCode
        // It also takes fullName class from FullName.java
        this.fullName = new FullName();
        this.streetAddress = "";
        this.city ="";
        this.province = "";
        this.postalCode = "";
    }

    public MailingAddress(FullName fullName, String streetAddress, String city, String province, String postalCode ){
        //Second constructor, takes four strings and a class as parameters
        // corresponding to the fullName, streetAddress, city, province, postalCode

        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public String toString(){
        String fullNameWithAddress = "";
        // adds fullName, streetAddress, city, province, postalCode into the empty string fullNameWithAddress.

        fullNameWithAddress += fullName + "\n";
        fullNameWithAddress += streetAddress + "\n";
        fullNameWithAddress += city + ", " + province + " " + postalCode;

        return fullNameWithAddress;
    }


}
