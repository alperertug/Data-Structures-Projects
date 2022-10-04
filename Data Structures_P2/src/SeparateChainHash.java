public class SeparateChainHash<Item> {
    int M;
    LinkedList<Item>[] table;
    
    public SeparateChainHash(int M) {
        table = new LinkedList[M];
        for (int ix = 0; ix < M; ix++) {
            table[ix] = new LinkedList<Item>();
        }
        this.M = M;

    }
    
    public int hash(Item t) {
        return ((Math.abs(t.hashCode())) % M);
    }
    
    
    public void insert(Item t) {
        int ix = hash(t);
        table[ix].insertFirst(t);
    }
    
    public String find(int hashData){
        int ix = ((Math.abs(hashData)) % M);
        if(table[ix] != null){
            return table[ix].findNode(hashData);
        }
        return "No such data found!";
    }
    
    public Item delete(int hashData){
        int ix = ((Math.abs(hashData)) % M);
        if(table[ix] != null){
            return table[ix].remove(hashData);
        }
        return null;
    }
    
    public String toString() {
        String s = "";
        int totalS = 0;
        for (int ix = 0; ix < M; ix++) {
            if (table[ix] != null) {
                s += table[ix].toString();
                totalS++;
            }
        }
        
        return s;
    }
    
    public void getSize(){
        int tSize = 0;
        for (int ix = 0; ix < M; ix++) {
            if (table[ix] != null) {
                tSize += table[ix].size();
            }
        }
        System.out.println("There are " + tSize + " songs in the list!");
    }
}
