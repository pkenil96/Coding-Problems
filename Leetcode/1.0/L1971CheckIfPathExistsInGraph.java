import java.util.*;

class DisjointSet{
    
    int N;
    int[] parent;
    
    DisjointSet(int N){
        this.N = N;
        this.parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
    }
    
    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB){
            return;
        }
        parent[parentA] = parentB;
    }
    
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean hasCycle(int a, int b){
        return find(a) == find(b);
    }
}

class Solution {
    
    public boolean dfs(List<List<Integer>> adjList, int source, int destination, boolean[] visited){
        if(source == destination){
            return true;
        }
        visited[source] = true;
        for(int neighbour: adjList.get(source)){
            if(!visited[neighbour] && dfs(adjList, neighbour, destination, visited)){
                return true;
            }
        }
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // USING DFS
        // List<List<Integer>> adjList = new ArrayList<>();
        // for(int i=0; i<n; i++){
        // 	adjList.add(new ArrayList<>());
        // }
        // for(int[] edge: edges){
        // 	adjList.get(edge[0]).add(edge[1]);
        // 	adjList.get(edge[1]).add(edge[0]);
        // }

        // boolean[] visited = new boolean[n];
        // return dfs(adjList, source, destination, visited);
        
        // USING DISJOINT SET
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge: edges){
            ds.union(edge[0], edge[1]);
        }
        return ds.find(source) == ds.find(destination);
    }
}