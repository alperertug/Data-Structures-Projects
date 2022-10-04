package question2;


public class DoubleNode {
    private String data;
    private DoubleNode next;
    private DoubleNode prev;
    private String check;

    

    public DoubleNode(String data) {
        this.data = data;
        next = null;
        prev = null;
        this.check = data;
    }
    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public DoubleNode getNext() {
        return next;
    }
    public void setNext(DoubleNode next) {
        this.next = next;
    }
    public DoubleNode getPrev() {
        return prev;
    }
    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
    @Override
    public String toString() {
        return "DoubleNode{" + "data=" + data + ", next=" + next + ", prev=" + prev + '}';
    }
}
