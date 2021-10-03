import java.io.*;
import java.util.*;

public class G13SpreadOfInfection {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static int countOfInfectedPeople(ArrayList<Edge>[] graph, int src, int t){
      int infectedCount = 0, time = 0;
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[graph.length];
      q.add(src);
      visited[src]=true;
      time++;
      infectedCount++;
      
      while(!q.isEmpty()){
         int size = q.size();
         time++;
         while(size > 0){
            size--;
            int curr = q.poll();
            for(Edge edge: graph[curr]){
               if(visited[edge.nbr] == true){
                  continue;
               }
               q.add(edge.nbr);
               visited[edge.nbr] = true;
               infectedCount++;
            }
         }
         if(time == t){
            return infectedCount;
         }
      }
      return infectedCount;
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
      int t = Integer.parseInt(br.readLine());
      
      System.out.println(countOfInfectedPeople(graph, src, t));
   }

}