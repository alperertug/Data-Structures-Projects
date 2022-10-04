package question2;

import java.util.Random;


public class DoubleLinkList {
    private DoubleNode first;
    private DoubleNode last;
    private int size;
     public DoubleLinkList() {
        first =null;
        last =null;
    }
    
    public int getSize() {
        return size;
    }

    public DoubleNode getFirst() {
        return first;
    }

    public DoubleNode getLast() {
        return last;
    }
    
    
    
    public void insertFirst(String data){
        DoubleNode tmp = new DoubleNode(data);
        if(first == null){
            first = tmp;
            last = tmp;
        }else{
            tmp.setNext(first);
            first.setPrev(tmp);
            first = tmp;
        }
        size++;
    }
    public void insertLast(String data){
         DoubleNode tmp = new DoubleNode(data);
         if(first == null){
            first = tmp;
            last = tmp;
        }else{
            tmp.setPrev(last);
            last.setNext(tmp);
            last = tmp;
        }
         size++;
    }
    public DoubleNode search(String data){
        DoubleNode check = first;
        while(check != null){
            if(check.getCheck().equalsIgnoreCase(data)){
                return check;
            }
            check = check.getNext();
        }
        return null;
    }
    
    public void hubStudents(int M){
        Random random=new Random();
        DoubleNode tmp;
        int k;
        int i=0;
        while(i<M){
            k=random.nextInt(size);
            tmp = kthStudent(k);
            if(tmp.getData().lastIndexOf("*") == -1){
                tmp.setData(tmp.getData()+"*");
                i++;
            }
         }
    }
    public DoubleNode kthStudent(int k){
        DoubleNode tmp = first;
        for(int i = 0; i < k; i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }
    public String transfer(String message, DoubleNode name, int k){
        DoubleNode tmp =search(name.getCheck());
        if(tmp == null){
            return "User not found!";
        }
        else{
            String s="";
            s+=tmp.getData()+" passes message " + message;
            Random random =new Random();
            boolean  r = random.nextBoolean();
            if(r){
                s+=" to forward:"+forwardWay(message,tmp,k);
            
            }else{
                s+=" to backward:"+backwardWay(message, tmp, k);
            }
        return s;
        }
        
    }
    public String forwardWay(String message,DoubleNode name,int k){
        DoubleNode tmp =search(name.getCheck());
        String s="";
        int control=0;
        for(int l=0;l<k;l++){
            tmp = tmp.getNext();
            if(tmp !=null){
            if(tmp.getData().charAt((tmp.getData().length())-1)== '*'){
                s+=tmp.getData()+",";
                control = 0;
                for (int i = 0; i < tmp.getData().length(); i++) {
                     for (int j = 0; j < message.length(); j++) {
                       if(tmp.getData().toLowerCase().charAt(i)== message.toLowerCase().charAt(j)){
                          control++;
                        }
                       if(control>=2){
                                s+=transfer(message,tmp,k);
                                break;
                            }
                       
                    }
                     if(control>=2){
                                break;
                            }
                }    
            }else{
                 s+=tmp.getData()+",";
            }
            if(control>=2){
               break;
             }
                    
        }else{
                s+="No one left";
                break;
                       
            }
        }
        return s;
    }
    public String backwardWay(String message,DoubleNode name,int k){
        DoubleNode tmp =search(name.getCheck());
        String s="";
        int control=0;
        for(int l=0;l<k;l++){
            tmp = tmp.getPrev();
            if(tmp!=null){
             if(tmp.getData().charAt((tmp.getData().length())-1)== '*'){
                s+=tmp.getData()+",";
                control = 0;
                for (int i = 0; i < tmp.getData().length(); i++) {
                     for (int j = 0; j < message.length(); j++) {
                       if(tmp.getData().toLowerCase().charAt(i)==message.toLowerCase().charAt(j)){
                          control++;   
                        }
                        if(control>=2){
                                s+=transfer(message,tmp,k);
                                break;
                            }
                       
                    }
                     if(control>=2){
                                break;
                            }
                }    
            }else{
                 s+=tmp.getData()+",";
            }
            if(control>=2){
               break;
             }
                    
        }else{
                s+="No one left";
                break;
                       
            }
       }
        return s;
    }
   
    
    @Override
    public String toString() {
        String str = "";
        DoubleNode tmp = first;
        while(tmp != null){
           str += tmp.getData()+"<->";
           tmp = tmp.getNext();
        }
        return str;
    }
    public boolean isEmpty(){
        return first == null;
    }
    
    public DoubleNode removeFirst(){
        if(isEmpty()){
            return null;
        }else{
            DoubleNode k = first;
            first.getNext().setPrev(null);
            first = first.getNext();
            size--;
            return k;
        }
    }
   
}
