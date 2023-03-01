//objectives fulfilled: Polymorphism and Abstraction
// so here bicycle takes the information from Cycle which has ride subclass and wheels subclass
public class Bicycle extends Cycle {
    public Bicycle(){
        this.cycle = "Bicycle";
    }

    @Override
    protected int wheels() {
        return 2; //bicycle consists of two wheels, thus returns 2
    }
}