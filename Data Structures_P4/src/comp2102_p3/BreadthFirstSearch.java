/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2102_p3;
import java.util.LinkedList;
/**
 *
 * @author 218EE2190
 */
public class BreadthFirstSearch {

    boolean[] marked;
    String[] edgeTo;
    int[] distTo;
    String from;
    String[] listAr;
    
    public BreadthFirstSearch(ListGraph g, String from) {
        edgeTo = new String[g.getNumV()];// warning this is initalized to 0 
        listAr = new String[g.getNumV()];
        marked = new boolean[g.getNumV()];
        distTo = new int[g.getNumV()];
        this.from = from;
        bfs(g,from);// this is not recursive
    }
    
    public boolean hasPathTo(int w) {
        return marked[w];
    }
    
    public int distTo(int w) {
        return distTo[w];
    }

    public String[] pathTo(ListGraph g,String source){
        String k = source;
        java.util.Stack<String> st = new java.util.Stack<String>();
        st.push(k);
        while (k != this.from) {
            //int a = distTo[g.search(k)];
            k = edgeTo[g.search(k)];
            st.push(k);
        }
        //st.push(from);

        String[] path = new String[st.size()];
        for (int i = 0; i < path.length; i++)
            path[i] = st.pop();
        return path;
    }
    
    public void printPathTo(ListGraph g, String source) {
        boolean ex = false;
        for(int i = 0;i<listAr.length;i++){
            if(listAr[i]==null){
                
            }
            else if(listAr[i].equals(source)){
                ex = true;
                break;
            }
        }
        if(!ex){
            System.out.println("Can not path");
            return;
        }
        String[] path = pathTo(g,source);
        
        for(int i = 0; i < path.length; i++){
            
            System.out.print(path[i]+"->");
        }
        System.out.println("");
    }

    // this is not recursive
    public void bfs(ListGraph g, String source) {
        int src = g.search(source);
        marked[src] = true;
        String[] a = (String[]) g.neighborsArray(source);
        if (a.length == 0) {
            return;
        }
        // this is to work as a queue
        java.util.LinkedList<String> q = new LinkedList<>();
        q.addLast(source);
        int j = 0;
        while (!q.isEmpty()) {
            source = q.removeFirst();
            listAr[j++] = source;
            src = g.search(source);
            a = (String[]) g.neighborsArray(source);
            for (int i = 0; i < a.length; i++) {
                int w = g.search(a[i]);
                if (!marked[w]){
                    //System.out.println(g.who(w)+".");
                    q.addLast(g.who(w));
                    marked[w] = true;
                    edgeTo[w] = source;
                    distTo[w] = distTo[src] + 1;
                }
            }
        }
    }
}
