import java.io.*;
import java.util.*;

public class G04ConnectedComponentsOfGraph {
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
   
   public static void dfs(ArrayList<Edge>[] graph, HashSet<Integer> visited, ArrayList<Integer> comp, ArrayList<ArrayList<Integer>> comps, int src){
       visited.add(src);
       comp.add(src);
       
       for(Edge e: graph[src]){
           if(!visited.contains(e.nbr)){
                dfs(graph, visited, comp, comps, e.nbr);
           }
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        
        // write your code here
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<vtces; i++){
            if(!visited.contains(i)){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph, visited, comp, comps, i);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }
    }