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
public class Node<Item> {
    Item data;
    int weight;
    Node<Item> next;
    
    public Node(Item data, int weight){
        this.data = data;
        this.weight = weight;
        next = null;
    }
    
    public Item getData() {
        return data;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
    public String toString(){
        return (""+data.toString());
    }
}
