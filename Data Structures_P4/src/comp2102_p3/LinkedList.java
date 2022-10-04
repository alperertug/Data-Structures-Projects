/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2102_p3;

/**
 *
 * @author ALPER
 */
public class LinkedList<Item> {
    Node<Item> first, last;
    int size = 0;
    String ıd ="empty";
    public LinkedList(){
        first = null;
        last = null;
        size = 0;
        ıd = "empty";
    }
    
    public String toString() {
        Node<Item> tmp = first;
        String str = ıd + ": ";
        while (tmp != null) {
            str += tmp.toString()+"("+tmp.weight+")" + " -> ";
            tmp = tmp.next;
        }
        
        return str;
    }
    
    public void add(Item x, int y) {
        Node newNode = new Node<Item>(x, y);
        Node current = first;
        if (first == null) {
            first = newNode;
            last = newNode;
            size++;
            return;
        }
        if(newNode.weight < current.weight){
            newNode.next = current;
            first = newNode;
            size++;
            return;
        }
        while (current.next != null) {            
            if(newNode.weight < current.next.weight){
            newNode.next = current.next;
            current.next = newNode;
            size++;
            return;
            }
            current = current.next;
        }
        last.next = newNode;
        last = newNode;
        size++;
    }
    
    public boolean contains(Item name){
        
        Node<Item> tmp = first;
        while (tmp != null) {            
            if (tmp.getData().equals(name)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
        
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
    
    public Item remove(String name){
        Node tmp = first;
        if (isEmpty()) {
            return null;
        }
        if (tmp.data.equals(name)) {
            return removeFirst();
        }
        while (tmp.next != null) {            
            if (tmp.next.data.equals(name)) {
                Node newNode = tmp.next;
                tmp.next = newNode.next;
                size--;
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
    
    public Object clone() {
        LinkedList<Item> clone = new LinkedList<>();

        for (Node<Item> x = first; x != null; x = x.next)
            clone.add(x.data, x.weight);

        return clone;
    }
    
    public void closest(int threshold){
        Node current = first;
        String s = "";
        while (current.weight <= threshold) {            
            s = s + current.data + ",";
            current = current.next;
        }
        System.out.println("Closest: " + s);
    }
    
    public void farther(int threshold){
        Node current = first;
        String s = "";
        while (current!=null && current.weight < threshold) {            
            
            current = current.next;
        }
        while (current!= null) {            
            s = s + current.data + ",";
            current = current.next;
        }
        System.out.println("Farther: " + s);
    }

    public void setId(String ıd) {
        this.ıd = ıd.toLowerCase();
    }

    public String getId() {
        return ıd;
    }
    public String[] toArray(){
    String[] ar = new String[size];
    Node tmp = first;
    int i = 0;
        while(tmp!=null){
            ar[i] = (String) tmp.data;
            i++;
            tmp = tmp.next;    
        }
        return ar;
    }
    public void updateWeight(String name,int weight){
        Node tmp = first;
        while(tmp!=null){
            if(tmp.data.equals(name)) break;
            tmp=tmp.next;
        }
        tmp.setWeight(weight);
        remove((String)tmp.data);
        add((Item)tmp.data,tmp.weight);
        
    }
    
}


