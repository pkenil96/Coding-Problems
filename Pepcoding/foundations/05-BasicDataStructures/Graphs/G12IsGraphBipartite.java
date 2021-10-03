import java.io.*;
import java.util.*;

public class G12IsGraphBipartite {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean isColoringPossible(ArrayList<Edge>[] graph, boolean[] visited, boolean[] color, int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        color[vertex] = true;
        visited[vertex] = true;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(Edge edge: graph[curr]){
                if(visited[edge.nbr] == false){
                    queue.add(edge.nbr);
                    visited[edge.nbr] = true;
                    color[edge.nbr] = !color[curr];
                } else if(color[edge.nbr] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                boolean result = isColoringPossible(graph, visited, color, i);
                if(result == false){
                    return false;
                }
            }
        }
        return true;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        System.out.println(isBipartite(graph));
    }
}