public class CircularList {
    private Node current;
    private int size = 0;

    public CircularList() {
        current = null;
    }

    public Node getCurrent() {
        return current;
    }
    
    public int getSize(){
        return size;
    }

    public void insertAfterCurrent(String s) {
        Node tmp = new Node(s);
        if (current == null) {
            current = tmp;
            current.setNext(current);
            current.setPrevious(current);
        } else {
            tmp.setPrevious(current);
            tmp.setNext(current.getNext());
            current.getNext().setPrevious(tmp);
            current.setNext(tmp);
        }
        size++;
    }

    public void rotate() {
        current = current.getNext();
    }
    public void rotatekth(int k) {
        for(int i =0;i<=k;i++){
        current = current.getNext();
        }
    }
    public void insertBeforeCurrent(String s) {
        Node tmp = new Node(s);
        if (current == null) {
            current = tmp;
            current.setNext(current);
            current.setPrevious(current);
        } else {
            tmp.setPrevious(current.getPrevious());
            current.getPrevious().setNext(tmp);
            tmp.setNext(current);
            current.setPrevious(tmp);
        }
        size++;
    }

    public String toString() {

        Node tmp = current;
        String s = "";
        if(getSize()==1){
            s ="The winner is "+current.getData() + "\nCongratulations!!!";
        }
        else{
            while (tmp != current.getPrevious()) {
                s += tmp.getData() + "<->";
                tmp = tmp.getNext();
        }
        s += tmp.getData();
        }
        

        return s;
    }
    public Node kthStudent(int k){
        Node tmp = current.getNext();
        for(int i=0;i<k;i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }
    public Node search(Node search){
        if(current.getData().equals(search.getData())){
            return current;
        }
        Node tmp = current.getNext();
            while(tmp!=current){
                if(tmp.getData().equals(search.getData())){
                    return tmp;
                }
                tmp = tmp.getNext();
            }
        return null;
    }
    
    public void remove(Node removed){
        Node tmp = search(removed);
        if(current == tmp){
            tmp.getNext().setPrevious(tmp.getPrevious());
            tmp.getPrevious().setNext(tmp.getNext());
            current = tmp.getNext();
        }else{
        tmp.getNext().setPrevious(tmp.getPrevious());
        tmp.getPrevious().setNext(tmp.getNext());
        }
        size--;
        String name = tmp.getData().substring(0,tmp.getData().length()-1);
        System.out.println(name+" is eleminated!");
    }
    
    public void removeNotPrint(Node removed){
        Node tmp = search(removed);
        if(current == tmp){
            tmp.getNext().setPrevious(tmp.getPrevious());
            tmp.getPrevious().setNext(tmp.getNext());
            current = tmp.getNext();
        }else{
        tmp.getNext().setPrevious(tmp.getPrevious());
        tmp.getPrevious().setNext(tmp.getNext());
        }
        size--;
    }
    
    public void deleteNodeChar(Node deleted){
        Node tmp = search(deleted);
        if(tmp.getControlData().length() == 0){
          //  remove(tmp);
        }else{
            String newData = tmp.getControlData().substring(0,tmp.getControlData().length()-1);
            tmp.setControlData(newData);
            tmp.setData(tmp.getData()+"*");
        }            
    }
    public void deleteNodeStar(Node deleted){
        Node tmp = search(deleted);
        if(tmp.getControlData().length() == 0){
            remove(tmp);
        }else{
            String newData = tmp.getData().substring(0,tmp.getData().length()-1);
            tmp.setData(newData);
        }            
    }
     
}
