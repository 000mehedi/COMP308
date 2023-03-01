//ComputerOrder is a generic container that stores IComputer interface's implementation
import java.util.ArrayList;

public class ComputerOrder<items extends IComputer> extends GenericOrder<items>{
    public ComputerOrder(){

    }
    public ComputerOrder(ArrayList<items> products){
        super(products);
    }
}

