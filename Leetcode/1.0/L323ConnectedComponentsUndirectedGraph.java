import java.util.*;

public class L323ConnectedComponentsUndirectedGraph {
    
    public static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int src){
        visited[src] = true;
        for(Integer node: adjList.get(src)){
            if(visited[node] == false){
                dfs(adjList, visited, node);
            }
        }
    }
    
    public static void bfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            for(Integer node: adjList.get(curr)){
                if(visited[node]==false){
                    q.add(node);
                }
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            adjList.get(src).add(des);
            adjList.get(des).add(src);
        }
        
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                dfs(adjList, visited, i);
                //bfs(adjList, visited, i);
                count++;
            }
        }
        return count;
    }
}