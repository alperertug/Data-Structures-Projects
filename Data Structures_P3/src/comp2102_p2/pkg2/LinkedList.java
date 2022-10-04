package comp2102_p2.pkg2;


public class LinkedList<Item> {
    Node<Item> first, last;
    int size = 0;
    
    public LinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    
    public String toString() {
        Node<Item> tmp = first;
        String str = " ";
        while (tmp != null) {
            str += tmp.toString()+ ",";
            tmp = tmp.next;
        }
        
        return str.substring(0, str.length()-1);
    }
    public void insertLast(Item x){
        Node newNode = new Node(x);
        Node control = search(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        }else if(control != null){
            size--;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    
    public void insertFirst(Item x , String location) {
        Node newNode = new Node<Item>(x);
        Node control = search(x);
        if (first == null) {
            newNode.list.insertLast(location);
            first = newNode;
            last = newNode;
        }else if(control != null){
            control.list.insertLast(location);
            size--;
        }else{
            newNode.list.insertLast(location);
            newNode.next = first;
            first = newNode;
        }
        size++;
    }
    public Node search(Item x){
        Node<Item> tmp = first;
        while(tmp !=null){
            if(tmp.data.equals(x)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
    
    public String findNode(Item x){
        
        Node tmp = first;
        while (tmp != null) {            
            if (tmp.data.equals(x)) {
                return "word has been appeared in the following text files:\n"+tmp.getFileName();
            }
            tmp = tmp.next;
        }
        return "Word is not found!";
        
    }
    
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<Item> tmp = first;
        first = first.next;
        size--;
        return tmp.data;
    }
    
    public Item remove(int hashData){
        Node tmp = first;
        if (isEmpty()) {
            return null;
        }
        if (tmp.data.hashCode() == hashData) {
            return removeFirst();
        }
        while (tmp.next != null) {            
            if (tmp.next.data.hashCode() == hashData) {
                Node newNode = tmp.next;
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
        Node tmp = first;
        int size = 0;
        while (tmp != null) {            
            size++;
            tmp = tmp.next;
        }
        return size;
    }
}

