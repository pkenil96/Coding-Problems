import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
    
        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    static class Pair{
        int vertex;
        String path;
        
        Pair(int vertex, String path){
            this.vertex = vertex;
            this.path = path;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
    
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
    
        int src = Integer.parseInt(br.readLine());
    
        // write your code here
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[vtces];
        q.add(new Pair(src, src+""));
        
        // follow r(remove), m*(mark if not already marked else exit), w(print in this case), a*(add the unvisited neighbours)
        while(!q.isEmpty()){
            // r
            Pair pair = q.poll();
            int vertex = pair.vertex;
            String path = pair.path;
            if(visited[vertex] == true){
                continue;
            }
            visited[vertex] = true;
            System.out.println(vertex + "@" + path);
            for(Edge edge: graph[vertex]){
                q.add(new Pair(edge.nbr, path+edge.nbr));
            }
        }
    }
}