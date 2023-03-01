 //Student ID: 3619873
      //   Student Name: Md Abdullah Mehedi Patwary
     //    Student email: mpatwary1@athabasca.edu
  //Date: 05/12/2022


public class Client {
    public static void main(String[] argv) {
        OrderProcessor processor = new OrderProcessor();
        Motherboard[] motherboards = {new Motherboard("Asus", 38)};
        ComputerOrder<Motherboard> order = new ComputerOrder<>(motherboards);
    }
}