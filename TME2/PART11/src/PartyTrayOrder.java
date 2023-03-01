public class PartyTrayOrder<items extends Product> extends GenericOrder<items> {
    public PartyTrayOrder(){
        super();
    }
    public PartyTrayOrder(items[] item){
        super(item);
    }
}