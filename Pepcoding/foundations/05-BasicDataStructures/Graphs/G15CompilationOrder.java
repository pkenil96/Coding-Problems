import java.io.*;
import java.util.*;

public class G15CompilationOrder {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

    public static void topologicalSort(ArrayList<Edge>[] graph, Stack<Integer> stack, boolean[] visited, int src){
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(visited[edge.nbr] == false){
                topologicalSort(graph, stack, visited, edge.nbr);
            }
        }
        stack.push(src);
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
      }

      // write your code here
      Stack<Integer> stack = new Stack<>();
      boolean[] visited = new boolean[vtces];
      for(int i=0; i<vtces; i++){
          if(visited[i] == false){
              topologicalSort(graph, stack, visited, i);
          }
      }
      while(!stack.isEmpty()){
          System.out.println(stack.pop());
      }
   }

}