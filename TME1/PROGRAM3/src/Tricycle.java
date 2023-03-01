
// so here tricycle takes the information from Cycle which has ride subclass and wheels subclass
public class Tricycle extends Cycle {
    public Tricycle(){
        this.cycle = "Tricycle";
    }

    @Override
    protected int wheels() {
        return 3;//tricycle consists of two wheels, thus returns 3
    }
}