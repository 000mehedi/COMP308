public class ComputerOrder<items extends Product> extends GenericOrder<items>{
    public ComputerOrder(){
        super();
    }
    public ComputerOrder(items[] item){
        super(item);
    }
}