import java.util.UUID;

/******************************************************************
 * COMP308 Java for Programmer,
 * SCIS, Athabasca University
 *
 * Assignment: TME2
 * @author: Steve Leung
 * @date  : Oct 21, 2005
 *
 *Modifications by:
 * Student ID: 3619873
 * Student Name: Md Abdullah Mehedi Patwary
 * Student email: mpatwary1@athabasca.edu
 * Date: 05/12/2022
 *
 ******************************************************************/

enum DriveType{
    SSD
}
interface IComputer{}
interface IParty{}
interface IComputerParty{}

abstract class Product {
    protected float price;
    protected UUID uUID;

    public float getPrice(){
        return price;
    }

    public String toString(){
        return getClass().getSimpleName() + "\nOrder number: " + uUID + "\nPrice: " + getPrice();
    }

}

//------------------------------------------------------------

class ComputerPart extends Product implements IComputer, IParty, IComputerParty {
    protected String manufacturer;
    public ComputerPart(String mfg, float p, float v) {
        this.manufacturer = mfg;
        this.price = p;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String toString() {
        return  super.toString() + "\nManufacturer: " + getManufacturer();
    }

    public void setuID(UUID x) {
    }
}

class Motherboard extends ComputerPart {
    public Motherboard(String mfg, float p) {
        super(mfg, p, p);
    }
}

class RAM extends ComputerPart {
    public RAM(String mfg, int size, float p) {
        super(mfg, size, p);
    }
}

class Drive extends ComputerPart {
    protected DriveType type;
    protected int speed;

    public Drive(String mfg, DriveType type, int size, int speed, float p) {
        super(mfg, size, p);
        this.type = type;
        this.speed = speed;
    }

    public DriveType getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public String toString() {
        return super.toString() + "\nType: " + getType() + "\nSpeed: " + getSpeed();
    }
}


class Peripheral extends Product implements IComputer,IParty, IComputerParty {
    protected String model;

    public Peripheral(String model, float p) {
        this.price = p;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        return super.toString() + "\nModel: " + getModel();
    }

    public void setuID(UUID x) {
    }
}

class Printer extends Peripheral {
    public Printer(String model, float p) {
        super(model, p);
    }
}

class Monitor extends Peripheral {
    public Monitor(String model, float p) {
        super(model, p);
    }
}

class Service extends Product implements  IComputer, IParty, IComputerParty{
    protected String partner;

    public Service(String partner, float p) {
        this.partner = partner;
        this.price = p;
    }

    public String getPartner() {
        return partner;
    }

    public String toString() {
        return super.toString() + "\nPartner: " + getPartner();
    }

    public void setuID(UUID x) {
    }
}

class AssemblyService extends Service {
    public AssemblyService(String partner, float p) {
        super(partner, p);
    }
}

class DeliveryService extends Service {
    public DeliveryService(String partner, float p) {
        super(partner, p);
    }
}

//-------------------------------------------------------
class Cheese extends Product implements IParty, IComputer, IComputerParty {
    protected float price;

    public Cheese(float p) {
        this.price = p;
    }

    public float getPrice(){
        return price;
    }

    public String toString() {
        return super.toString()+ "\nPrice $: " + getPrice();
    }

    public void setuID(UUID x) {
    }
}

class Cheddar extends Cheese {
    public Cheddar(float p) {
        super(p);
    }
}
class Mozzarella extends Cheese {
    public Mozzarella(float p) {
        super(p);
    }
}

class Fruit extends Product implements  IParty, IComputer, IComputerParty {
    protected float price;

    public Fruit(float p) {
        this.price = p;
    }
    public float getPrice(){
        return price;
    }

    public String toString() {
        return super.toString()+ "\nPrice $: " + getPrice();
    }

    public void setuID(UUID x) {
    }
}
class Apple extends Fruit {
    public Apple(float p) {
        super(p);
    }
}
class Orange extends Fruit {
    public Orange(float p) {
        super(p);
    }
}
