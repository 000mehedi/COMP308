public abstract class Cycle {
    String cycle;

    public Cycle(){
        this.cycle = "Cycle";
    }

    public void ride(){
        System.out.println("I'm riding a " + cycle + " which has " + wheels() + " wheels.");
    }
    protected abstract int wheels();
}