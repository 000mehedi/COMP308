//PartyTrayOrder is a generic container that stores IParty interface's implementation
import java.util.ArrayList;

public class PartyTrayOrder<items extends IParty> extends GenericOrder<items> {
    public PartyTrayOrder(){

    }
    public PartyTrayOrder(ArrayList<items> products){
        super(products);
    }
}