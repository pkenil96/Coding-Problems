import java.util.*;

public class CycleInUndirectedGraph {
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int src, int parent){
        visited[src] = true;
        for(int neighbor: adjList.get(src)){
            if(visited[neighbor] == false){
                if(dfs(adjList, visited, neighbor, src)){
                    return true;
                }
            } else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
    
    public static boolean bfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node] == true){
                return true;
            }
            visited[node] = true;
            for(int neighbor: adjList.get(node)){
                if(visited[neighbor] == false){
                    q.add(neighbor);
                }
            }
        }
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int N, ArrayList<ArrayList<Integer>> adjList) {
        boolean cycleExists = false;
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++){
            if(visited[i] == false){
                // cycleExists = dfs(adjList, visited, i, -1);
                cycleExists = bfs(adjList, visited, i);
                if(cycleExists){
                    return true;
                }       
            }
        }
        return false;
    }
}