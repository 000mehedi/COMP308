 //Student ID: 3619873
         //Student Name: Md Abdullah Mehedi Patwary
         //Student email: mpatwary1@athabasca.edu
//  Date: 05/12/2022


public class Client {
    public static void main(String[] argv) {
        //implements through IComputer interface, with all the subclasses along with test data
        ComputerOrder<IComputer> order = new ComputerOrder<>();

        //ComputerPart(test data)
        order.addProduct(new Motherboard("Asus", 625));
        order.addProduct(new RAM("MSI", 16384, 340));
        order.addProduct(new Drive("WD", DriveType.SSD, 256, 5400, 120));

        //Peripheral(test data)
        order.addProduct(new Printer("HP 2742e", 70));
        order.addProduct(new Monitor("LG 29WP500", 255));

        //Service(test data)
        order.addProduct(new AssemblyService("Staples", 90));
        order.addProduct(new DeliveryService("UPS", 25));

        //Cheese(test data)
        order.addProduct(new Cheddar(3));
        order.addProduct(new Mozzarella(5));

        //Fruit(test data)
        order.addProduct(new Apple(2));
        order.addProduct(new Orange(2));


        //implements through IParty interface, with all the subclasses along with test data
        PartyTrayOrder<IParty> order2 = new PartyTrayOrder<>();

        order2.addProduct(new Motherboard("Asus", 625));
        order2.addProduct(new RAM("MSI", 16384, 340));
        order2.addProduct(new Drive("WD", DriveType.SSD, 256, 5400, 120));

        order2.addProduct(new Printer("HP 2742e", 70));
        order2.addProduct(new Monitor("LG 29WP500", 255));


        order2.addProduct(new AssemblyService("Memory Express", 70));
        order2.addProduct(new DeliveryService("Purolator", 30));

        order2.addProduct(new Cheddar(3));
        order2.addProduct(new Mozzarella(5));

        order2.addProduct(new Apple(2));
        order2.addProduct(new Orange(2));

        //implements through IComputerParty interface, with all the subclasses along with test data
        ComputerPartyOrder<IComputerParty> order3 = new ComputerPartyOrder<>();


        order3.addProduct(new Motherboard("Asus", 625));
        order3.addProduct(new RAM("MSI", 16384, 340));
        order3.addProduct(new Drive("WD", DriveType.SSD, 256, 5400, 120));

        order3.addProduct(new Printer("HP 2742e", 70));
        order3.addProduct(new Monitor("LG 29WP500", 255));


        order3.addProduct(new AssemblyService("Memory Express", 70));
        order3.addProduct(new DeliveryService("Purolator", 30));

        order3.addProduct(new Cheddar(3));
        order3.addProduct(new Mozzarella(5));

        order3.addProduct(new Apple(2));
        order3.addProduct(new Orange(2));

        //empty order processor
        OrderProcessor processor = new OrderProcessor();

        //accepts the 3 orders
        processor.accept(order);
        processor.accept(order2);
        processor.accept(order3);

        //process the orders
        processor.process();

        //dispatch according to the subclasses
        processor.dispatchComputerParts();
        processor.dispatchPeripherals();
        processor.dispatchServices();
        processor.dispatchCheeses();
        processor.dispatchFruits();







    }
}