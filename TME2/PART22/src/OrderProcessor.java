import java.util.ArrayList;
import java.util.UUID;

@SuppressWarnings("ALL")
public class OrderProcessor {
    public ArrayList<GenericOrder> orders;
    public ArrayList<Tuple> parts;
    public ArrayList<Tuple> peripherals;
    public ArrayList<Tuple> services;
    public ArrayList<Tuple> cheeses;
    public ArrayList<Tuple> fruits;

    public OrderProcessor() {
        //initializing all the collections into different tuples
        this.orders = new ArrayList<>();
        this.parts = new ArrayList<Tuple>();
        this.peripherals = new ArrayList<Tuple>();
        this.services = new ArrayList<Tuple>();
        this.cheeses = new ArrayList<Tuple>();
        this.fruits = new ArrayList<Tuple>();
    }
    //adds order into the orders tuple
    public void accept(GenericOrder order){
        orders.add(order);
    }

    //process the orders
    public void process(){
        for (GenericOrder order : orders){
            ArrayList<Product> products = order.getProducts();
            // loops through every product , adds to respective tuples
            for (Product product : products){
                switch(product.getClass().getSuperclass().getSimpleName()) {
                    case "ComputerPart":
                        parts.add(new Tuple(order.getuID(), (ComputerPart)product));
                    case "Peripheral":
                        peripherals.add(new Tuple(order.getuID(), (Peripheral)product));
                    case "Service":
                        services.add(new Tuple(order.getuID(), (Service)product));
                    case "Cheese":
                        cheeses.add(new Tuple(order.getuID(), (Cheese)product));
                    case "Fruit":
                        fruits.add(new Tuple(order.getuID(), (Fruit)product));

                }

            }

        }
    }
    //adds a list of ComputerPart into the tuple
    public void dispatchComputerParts(){
        ArrayList<Product> products = new ArrayList<>();
        for(Tuple<UUID, ComputerPart> tuple : parts) {
            tuple.y.setuID(tuple.x);
            products.add(tuple.y);
        }
        //test print
        System.out.println(products);


    }
    //adds a list of Peripheral into the tuple
    public void dispatchPeripherals(){
        ArrayList<Product> products = new ArrayList<>();
        for(Tuple<UUID, Peripheral> tuple : peripherals) {
            tuple.y.setuID(tuple.x);
            products.add(tuple.y);

        }
        System.out.println(products);

    }
    //adds a list of Service into the tuple
    public void dispatchServices(){
            ArrayList<Product> products = new ArrayList<>();
            for(Tuple<UUID, Service> tuple : services) {
                tuple.y.setuID(tuple.x);
                products.add(tuple.y);
            }
        System.out.println(products);

    }

    //adds a list of Cheese into the tuple
    public void dispatchCheeses(){
        ArrayList<Product> products = new ArrayList<>();
        for(Tuple<UUID, Cheese> tuple : cheeses) {
            tuple.y.setuID(tuple.x);
            products.add(tuple.y);
        }
        System.out.println(products);

    }
    //adds a list of Fruit into the tuple
    public void dispatchFruits(){
        ArrayList<Product> products = new ArrayList<>();
        for(Tuple<UUID, Fruit> tuple : this.fruits) {
            tuple.y.setuID(tuple.x);
            products.add(tuple.y);
        }
        System.out.println(products);

    }
}
