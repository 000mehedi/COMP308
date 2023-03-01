/*Task:
    -Create an abstract class
        -arraylist to store the items stored
        - random unique id(UID) to specify the items stored into arraylist, we can also use random.nextInt but I prefer UUID
        - a confirmation message about the order( a print statement)
  */

import java.util.ArrayList;

import java.util.Arrays;
import java.util.UUID;

public abstract class GenericOrder<items>{
    public UUID uID;
    public ArrayList<items> items;


    public GenericOrder(){
        this.uID = UUID.randomUUID();
        this.items = new ArrayList<>();
    }

    public GenericOrder(items[] items){
        this.uID = UUID.randomUUID();
        this.items = new ArrayList<>(Arrays.asList(items));

    }

    public void add(items item){
        items.add(item);

    }
    public void remove(items item){
        items.remove(item);
    }
    public ArrayList<ItemOrdered<UUID , items>> process(){
        ArrayList<ItemOrdered<UUID, items>> item_ordered = new ArrayList<>();

        for (items item : items) {
            item_ordered.add(new ItemOrdered<>(uID, item));
        }
        return item_ordered;

    }



}