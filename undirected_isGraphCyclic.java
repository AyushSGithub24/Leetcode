import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class undirected_isGraphCyclic {
    //problem link
    // https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
    // bfs solution
     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i] && bfs(i,adj,vis)){
                return true;
            }
        }
        return false;
    }
    boolean bfs(int n,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{n,-1});
        vis[n]=true;
        
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int node=arr[0];
            int parent=arr[1];
            for(int i:adj.get(node)){
                if(!vis[i]){
                    vis[i]=true;
                    q.add(new int[]{i,node});
                }else if(i!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    // dfs solution
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, adj, vis, -1)) {
                return true;
            }
        }
        return false;
    }
     private static boolean dfs(int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[n] = true;
        for (int num : adj.get(n)) {
            if (num == parent) {
                continue;
            }
            if (vis[num]) {
                return true;
            }
            if (dfs(num, adj, vis, n)) {
                return true;
            }
        }
        return false;
    }
}