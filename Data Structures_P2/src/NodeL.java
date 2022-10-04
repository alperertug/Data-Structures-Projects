public class NodeL<Item> {
    Item data;
    NodeL<Item> next;
    
    public NodeL(Item data){
        this.data = data;
        next = null;
    }
    
    public String toString(){
        return (""+data.toString());
    }
}
