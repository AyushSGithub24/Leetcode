import java.util.*;
/********************************************** */
//bfs
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        //bfs
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            // System.out.println(node);
            if (node == destination)
                return true;
            List<Integer> arr = map.get(node);
            for (int i : arr) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;

    }
}
/************************************************************* */
//dfs
class help {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
       boolean visited[]=new boolean[n];

        return dfs(source,destination,map,visited);
    }

    boolean dfs(int source,int destination,Map<Integer, List<Integer>> map ,boolean visited[]){
        if(source==destination) return true;
        visited[source]=true;
        for(int i:map.get(source)){
            if(!visited[i]){
                // visited[i]=true;
                if(dfs(i,destination,map,visited)) return true;
            }
        }
        return false;
    }
}