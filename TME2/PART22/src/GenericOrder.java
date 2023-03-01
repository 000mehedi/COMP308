/*Task:
    -Create an abstract class
        -arraylist to store the items stored
        - random unique id(UID) to specify the items stored into arraylist, we can also use random.nextInt but I prefer UUID
        - a confirmation message about the order( a print statement)
  */

import java.util.ArrayList;
import java.util.UUID;

public abstract class GenericOrder<items>{
    public UUID uID;
    public ArrayList<items> products = new ArrayList<>();

    //default constructor, contains random uID
    public GenericOrder(){
        this.uID = UUID.randomUUID();

    }

    public GenericOrder(ArrayList<items> products){
        this.products = products;

    }
    //getter for uID
    public UUID getuID(){
        return uID;
    }
    //getter for products
    public ArrayList<items> getProducts() {
        return products;
    }
    //adds products
    public void addProduct(items product){
        products.add(product);
    }


}



