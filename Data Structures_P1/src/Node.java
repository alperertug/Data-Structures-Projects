public class Node {
    private String data;
    private Node next;
    private Node previous;
    private String controlData;
        public Node(String data) {
            this.data = data;
            next = null;
            previous = null;
            this.controlData = data;
        }

    public String getControlData() {
        return controlData;
    }

    public void setControlData(String controlData) {
        this.controlData = controlData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
