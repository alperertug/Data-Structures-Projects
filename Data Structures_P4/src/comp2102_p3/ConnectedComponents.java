/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2102_p3;

/**
 *
 * @author 218EE2190
 */
public class ConnectedComponents {
    private boolean marked[];
    private int count;
    private int[] id;
    
    public ConnectedComponents(ListGraph g){
        marked = new boolean[g.getNumV()];
        count = 0; 
        id  = new int[g.getNumV()];
        for(int v = 0; v < g.getNumV(); v++){
            if(!marked[v]){
                dfs(g,g.who(v));
                count++;
            }             
        }
        String[] prt = new String[count];
        for(int i=0;i<g.getNumV();i++){
            if(prt[id[i]]==null){
                 prt[id[i]] =g.who(i);
            }else{
                 prt[id[i]] =prt[id[i]]+","+g.who(i);
            }
        }
        for(int j = 0;j<prt.length;j++){
            System.out.println("Group " +j+" :"+ prt[j]);
        }
    }
    
    public void dfs(ListGraph g, String v){
        marked[g.search(v)] = true;
        id[g.search(v)] = count;
        String[] a = (String[]) g.neighborsArray(v);
        for(int i = 0; i < a.length; i++){
            if(!marked[g.search(a[i])]){
                dfs(g,a[i]);
            }
        }

    }
           
}
