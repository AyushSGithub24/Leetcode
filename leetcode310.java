import java.util.*;
// graph question use bfs topology sort
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList();
        if (n < 2) {
            for (int i = 0; i < n; i++)
                result.add(i);
            return result;
        }

        int[] indegree = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : edges)
        {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        

        for (int i = 0; i < n; i++){
            if(indegree[i] == 1)
            q.offer(i);
        }

        int size = 0;
        while(!q.isEmpty())
        {
            result = new ArrayList();
            size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                result.add(node);
                indegree[node]--;
                
                for (int neighbor : adj[node]) {                    
                    indegree[neighbor]--;
                    
                    if (indegree[neighbor] == 1)
                        q.add(neighbor);
                }
            }
        }
        return result; 
    }
}