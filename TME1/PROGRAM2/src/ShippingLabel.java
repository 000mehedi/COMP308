//Name: Md. Abdullah Mehedi Patwary
//ID: 3619873
//Email: mpatwary1@athabasca.edu
//Date: 07/11/2022

//To run this program:
//Open the whole PROGRAM2 folder into IntellIJ or Eclipse
//Run ShippingLabelTest.java to check if it pass all the tests over ShippingLabel.java


public class ShippingLabel {
    //initializing the variables
    private final MailingAddress fromMailingAddress;
    private final MailingAddress toMailingAddress;


    public ShippingLabel(){
        //Default Constructor, does not take any parameter and
        //takes data from MailiAddress class and supplies to fromMailingAddress and toMailingAddress
        this.fromMailingAddress = new MailingAddress();
        this.toMailingAddress = new MailingAddress();
    }

    public ShippingLabel(MailingAddress fromMailingAddress, MailingAddress toMailingAddress){
        //Second constructor, takes two classes as parameters
        // corresponding to fromMailingAddress and toMailingAddress
        this.fromMailingAddress = fromMailingAddress;
        this.toMailingAddress = toMailingAddress;
    }

    public String toString(){
        String label = "";
        // adds toMailingAddress into the empty string label.
        label += toMailingAddress;
        //System.out.println(label);

        return label;
    }

    public static void main(String[] args) {
        MailingAddress fromMailingAddress = new MailingAddress();

        FullName fullName = new FullName("Md.", "Abdullah", "Mehedi", "Patwary");
        MailingAddress toMailingAddress = new MailingAddress(fullName, "1 University Dr,", "Athabasca", "AB", "T9S 3A3");

        ShippingLabel label = new ShippingLabel(fromMailingAddress, toMailingAddress);
        System.out.println(label);
    }


}
