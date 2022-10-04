
import java.util.NoSuchElementException;


public class SongTree<Item> {
    Node<Item> root;
    int[] arr;
    int i;


    public SongTree() {
        root=null;
    }
    public void addNode(int key, Item nm) {
        if (root == null) {
            root = new Node(key, nm);
        } else {
            Node tmp = root;
            Node parent = root;
            while (tmp != null) {
                parent = tmp;
                if (key < tmp.key) {
                    tmp = tmp.left;
                }else{
                    tmp = tmp.right;
                }
            }
            Node n = new Node(key, nm);
            if (key < parent.key) {
                parent.left = n;
            }else{
                parent.right = n;
            }
        }
    }
    public Node search(int key) {
         return searchRecursive(this.root, key);
    }
    public Node searchRecursive(Node focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) 
        {
            return focus;
        } else if (key < focus.key){ 
            return searchRecursive(focus.left, key);
        } else {
            return searchRecursive(focus.right, key);
        }
    } 
    
    public int [] searchU(int key) {
        this.arr = new int[0];
         this.i =0;
        searchRecursiveU(this.root, key);
        return arr;
    }
    
    public Node searchRecursiveU(Node focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) 
        {
           if(arr.length == i){
               arr = resize(arr);
           }
           arr[i] =(int) focus.data;
           i++;
           return searchRecursiveU(focus.right, key);
            
        } else if (key < focus.key){ 
            return searchRecursiveU(focus.left, key);
        } else {
            return searchRecursiveU(focus.right, key);
        }
    }
    
    private int [] resize(int [] array){
        int[] newArray = new int[array.length + 1];
        for(int j = 0; j < array.length; j++){
            newArray[j] = array[j];
        }
        return newArray;
    }
    
    public int [] bound(int a, int b){
        int[] boundArray = new int[0];
        int j = 0;
        int searchArray;
        for (int i = a; i <= b; i++) {
            searchArray = searchID(i);
            if (searchArray != -1) {
                boundArray = resize(boundArray);
                boundArray[j] = searchArray;
                j++;
            }
        }
        return boundArray;
    }
    
    
    public Node delete(Node focus,int key, Item data) {
        if (focus == null){
            return null;
        }
        if (key < focus.key){
            focus.left  = delete(focus.left,  key, data);
        } else if (key >= focus.key && !data.equals(focus.data)){
            focus.right = delete(focus.right, key, data);
        }else {
            if (focus.right == null){
                return focus.left;
            }
            if (focus.left  == null){
                return focus.right;
            }
            Node t = focus;
            focus = min(t.right); 
            focus.right = deleteMin(t.right); 
            focus.left = t.left;
        }
        return focus;
    }
    
    public void delete(int key, Item data) {

        if (root != null) {
            root = delete(root, key, data);
        }
    }
    
    
    public Node deleteMin(Node x) {
        if (root==null){
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }
    
    
    
    public Node min(Node x) {
        if(root==null) {
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.left == null){
            return x;
        }
        else {
            return min(x.left);
        }
    }
    
    
    
    
    public int searchID(int key) {
        Node tmp = searchRecursiveID(this.root, key);
        if (tmp == null) {
            return -1;
        }
        return (Integer) tmp.data;
    }
    
    public Node searchRecursiveID(Node focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) 
        {
            return focus;
            
        } else if (key < focus.key){ 
            return searchRecursiveID(focus.left, key);
        } else {
            return searchRecursiveID(focus.right, key);
        }
    }
}
