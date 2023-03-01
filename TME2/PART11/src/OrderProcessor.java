import java.util.ArrayList;
import java.util.UUID;

@SuppressWarnings("ALL")
public class OrderProcessor {
    public ArrayList<GenericOrder> orders;
    public ArrayList<ItemOrdered<UUID, ComputerPart>> parts;
    public ArrayList<ItemOrdered<UUID, Peripheral>> peripherals;
    public ArrayList<ItemOrdered<UUID, Service>> services;
    public ArrayList<ItemOrdered<UUID, Cheese>> cheeses;
    public ArrayList<ItemOrdered<UUID, Fruit>> fruits;


    public void accept(GenericOrder order){
        this.orders.add(order);
    }

    public void process(){
        for (int i =0; i < orders.size(); i++ ){
            ArrayList<ItemOrdered> items = orders.get(i).process();

            for (int j =0; j < orders.size(); j++ ){
                ItemOrdered item = items.get(j);

                if(item.type == "ComputerPart"){
                    parts.add(item);
                }
                else if(item.type == "Peripheral"){
                    peripherals.add(item);
                }
                else if(item.type == "Service"){
                    services.add(item);
                }
                else if(item.type == "Cheese"){
                    cheeses.add(item);
                }
                else if(item.type == "Fruit"){
                    fruits.add(item);
                }

            }

        }
    }
    public void dispatchComputerParts(){
        for (int i =0; i < parts.size(); i++ ){
            ItemOrdered<UUID, ComputerPart> part = parts.get(i);

            if(part.item instanceof Motherboard){
                System.out.println("Motherboard name=" + ((Motherboard) part.item).getManufacturer() +
                        ", price=" + part.item.price() +
                        ", order id=" +part.uID);
            }

            if (part.item instanceof RAM ){
                System.out.println("Ram name=" + ((RAM) part.item).getManufacturer() +
                        ", price=" + part.item.price() +
                        ", order id=" +part.uID);
            }

            if (part.item instanceof Drive ){
                System.out.println("Drive type=" + ((Drive) part.item).getType() +
                        ", speed=" + ((Drive) part.item).getSpeed());
            }
        }
    }
    public void dispatchPeripheral(){
        for (int i =0; i < peripherals.size(); i++ ){
            ItemOrdered<UUID, Peripheral> peripheral = peripherals.get(i);

            if(peripheral.item instanceof Monitor){
                System.out.println("Monitor model=" + ((Monitor) peripheral.item).getModel() +
                        ", price=" + peripheral.item.price());

            }

            if(peripheral.item instanceof Printer){
                System.out.println("Printer model=" + ((Printer) peripheral.item).getModel());

            }
        }
    }
    // for releasing the service items into the cart

    public void dispatchService(){

        for (int i =0; i < services.size(); i++ ) {
            ItemOrdered<UUID, Service> service = services.get(i);

            if(service.item instanceof AssemblyService){
                System.out.println("Assembly Provider=" + ((AssemblyService) service.item).getProvider());
            }

            if(service.item instanceof DeliveryService){
                System.out.println("Courier Provider=" + ((DeliveryService) service.item).getCourier());
            }

        }

        }
    public void dispatchCheese(){
        for (int i =0; i < cheeses.size(); i++ ) {
            ItemOrdered<UUID, Cheese> cheese = cheeses.get(i);
            if(cheese.item instanceof Cheddar){
                System.out.println("Cheddar Cheese Price=" + ((Cheddar) cheese.item).price());
            }
            if(cheese.item instanceof Mozzarella){
                System.out.println("Mozzarella Cheese Price=" + ((Mozzarella) cheese.item).price());
            }

        }

    }
    public void dispatchFruit(){
        for (int i =0; i < fruits.size(); i++ ) {
            ItemOrdered<UUID, Fruit> fruit = fruits.get(i);

            if(fruit.item instanceof Apple){
                System.out.println("Apple Price=" + ((Apple) fruit.item).price());
            }
            if(fruit.item instanceof Orange){
                System.out.println("Orange Price=" + ((Orange) fruit.item).price());
            }



        }

    }
}
