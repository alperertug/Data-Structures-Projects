package comp2102_p2.pkg2;

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
    
    
    public void insert(Item t,String location) {
        int ix = hash(t);
        table[ix].insertFirst(t,location);
    }
    
    public String find(Item x){
        int ix = (hash(x));
        if(table[ix] != null){
            return this.table[ix].findNode(x);
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
                s += table[ix].toString()+"\n";
                totalS++;
            }
        }
        
        return s;
    }
}
