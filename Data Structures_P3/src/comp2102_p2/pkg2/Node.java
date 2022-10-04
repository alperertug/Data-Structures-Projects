package comp2102_p2.pkg2;


public class Node<Item> {
    Item data;
    Node<Item> next;
    public LinkedList<String> list;
    public Node(Item data){
        this.data = data;
        next = null;
        list = new LinkedList<>();
    }
    public String getFileName(){
        return (""+list.toString());
    }
    public String toString(){
        return (""+data.toString());
    }
}
