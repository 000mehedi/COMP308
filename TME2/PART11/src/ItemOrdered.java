public class ItemOrdered<UUID, item> {

    public UUID uID;
    public item item;
    public String type;


    public ItemOrdered(UUID uID, item item){
        this.uID = uID;
        this.item = item;
        this.type = String.valueOf(item.getClass());
        
    }
}
