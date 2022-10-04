package comp2102_p3;


public class ListGraph {

    LinkedList<String>[] edges;
    private int numV;
    private int numE;

   
    public ListGraph(int V) {
        this.numV = V;
        edges = (LinkedList<String>[]) new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<String>();
        }
    }

    public int hash(String t) {
        return ((Math.abs(t.hashCode())) % numV);
    }
    
    public int getNumE() {
        return numE;
    }

    public int getNumV() {
        return numV;
    }

    public void addEdge(String from, String to, int weight) {
        int frm = search(from);
        int too = search(to);
        if(frm == -1){
            frm = hash(from);
           while(!edges[frm].getId().equals("empty")){
               frm =((frm+1)%numV);
            }
          //  System.out.println(from + " created");
        }
        edges[frm].setId(from);
        if(too == -1){
            too = hash(to);
           while(!edges[too].getId().equals("empty")){
               too =((too+1)%numV);
            }
         //  System.out.println(to + " created");
        }
          
          edges[too].setId(to);
          edges[frm].add(to, weight);
          edges[too].add(from, weight);
          numE++;
          
    }

    public void removeEdge(String from, String to) {
        int frm = search(from);
        int too = search(to);
        if(frm == -1 || too == -1){
            System.out.println("Character not found!");
            return;
        }
        if (edges[frm].contains(to)) {
             edges[frm].remove(to);
             edges[too].remove(from);
             System.out.println("Connection deleted!");
        } else {
        System.out.println("Edge not found!");
                }
        }
  

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < numV; i++) {
            if(!edges[i].getId().equals("empty")){
              sb.append(i + " " + edges[i].toString() + "\n");
            }
        }

        return sb.toString();
    }

    public boolean isAdjacent(String from, String to) {
        int frm = search(from);
        if(frm == -1){
           return false;
        }
        return edges[frm].contains(to);
    }

    public LinkedList<String> neighborsList(String from) {
        int frm = search(from);
        if(frm == -1){
           return null;
        }
        return (LinkedList<String>) edges[frm].clone();
    }

    public int degree(String from) {
        int frm = search(from);
        if(frm == -1){
           return 0;
        }
        return edges[frm].size();
    }

    public int maxDegree() {
        int maxDegree = edges[0].size();
        for (int i = 0; i < edges.length; i++) {
            if (maxDegree < edges[i].size()) {
                maxDegree = edges[i].size();
            }
        }
        return maxDegree;
    }
    
    public void printClosesestCharacters(String toCharacter, int threshold){
        int frm = search(toCharacter);
        if(frm == -1){
           return ;
        }
        edges[frm].closest(threshold);
    }
    
    public void printFartherCharacters(String toCharacter, int threshold){
        int frm = search(toCharacter);
        if(frm == -1){
           return ;
        }
        edges[frm].farther(threshold);
    }
    
    public boolean isConnected(String character1, String character2){
        int frm = search(character1);
        if(frm == -1){
           return false;
        }
        return edges[frm].contains(character2);
    }
    public int search(String find){
        int fnd = hash(find);
        int control = fnd;
        while(!edges[fnd].getId().equals("empty")){
            if(edges[fnd].getId().equals(find)){
                return fnd;
            }
        fnd =((fnd+1)%numV);
            if (control == fnd) {
                break;
            }
    }
        //System.out.println(find + " not found");
        return -1;
    }
    public String[] neighborsArray(String from) {
        int frm = search(from);
        if(frm == -1) return null;
        String[] ar = new String[edges[frm].size()];
        ar = edges[frm].toArray();
        return ar;
    }
    public String who(int fnd){
        return edges[fnd].ıd;
    }
    public void change(String from,String to,int weight){
        int frm = search(from);
        int too = search(to);
        if(frm == -1 || too == -1){
           return;
        }
        if(!edges[frm].contains(to)) return;
        edges[frm].updateWeight(to, weight);
        edges[too].updateWeight(from, weight);
        System.out.println("Changed!");
    }
    public int size(){
        int count = 0;
        for(int i = 0;i<numV;i++){
            if(edges[i].size==0){
                count++;
            }
                
            
        }
        return count;
    }
    public void muchKnow(){
        int count=0;
        int loca =0;
        for(int i = 0;i<numV;i++){
            if(edges[i].size>count){
               count= edges[i].size ;
               loca=i;
            }
        }
        System.out.println(edges[loca].toString());
    }
    public void commanKnow(String frm,String to){
        int fr = search(frm);
        int too = search(to);
        String s="Common friends: "; 
        if(fr==-1 || too == -1) return;
        String[] frNeig = edges[fr].toArray();
        String[] toNeig = edges[too].toArray();
        for(int i = 0;i<frNeig.length;i++){
            for(int j=0;j<toNeig.length;j++){
                if(frNeig[i].equals(toNeig[j])){
                    s=s+frNeig[i]+", ";
                }
            }
        }
        System.out.println(s);
        
    }
}
