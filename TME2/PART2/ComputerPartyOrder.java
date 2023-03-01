//ComputerPartyOrder is a generic container that stores IComputerParty interface's implementation
import java.util.ArrayList;

public class ComputerPartyOrder<items extends IComputerParty> extends GenericOrder<items>{
    public ComputerPartyOrder(){}

    public ComputerPartyOrder(ArrayList<items> products){
        super(products);
    }
}