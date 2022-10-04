public class LinkedList<Item> {
    NodeL<Item> first, last;
    int size = 0;
    
    public LinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    
    public String toString() {
        NodeL<Item> tmp = first;
        String str = "";
        while (tmp != null) {
            str += tmp.toString() + "\n";
            tmp = tmp.next;
        }
        
        return str;
    }
    
    public void insertFirst(Item x) {
        NodeL newNode = new NodeL<Item>(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }
    
    public String findNode(int hashData){
        
        NodeL tmp = first;
        while (tmp != null) {            
            if (tmp.data.hashCode() == hashData) {
                return tmp.data.toString();
            }
            tmp = tmp.next;
        }
        return "Song is not found!";
        
    }
    
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        NodeL<Item> tmp = first;
        first = first.next;
        size--;
        return tmp.data;
    }
    
    public Item remove(int hashData){
        NodeL tmp = first;
        if (isEmpty()) {
            return null;
        }
        if (tmp.data.hashCode() == hashData) {
            return removeFirst();
        }
        while (tmp.next != null) {            
            if (tmp.next.data.hashCode() == hashData) {
                NodeL newNode = tmp.next;
                tmp.next = newNode.next;
                return (Item) newNode.data;
            }
            tmp = tmp.next;
        }
        return null;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size(){
        NodeL tmp = first;
        int size = 0;
        while (tmp != null) {            
            size++;
            tmp = tmp.next;
        }
        return size;
    }
}
