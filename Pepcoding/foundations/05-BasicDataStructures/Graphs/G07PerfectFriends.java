import java.io.*;
import java.util.*;

public class G07PerfectFriends {
   
   public static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> temp, int src){
       visited[src] = true;
       temp.add(src);
       for(Integer node: adjList.get(src)){
           if(visited[node]==false){
               dfs(adjList, visited, temp, node);
           }
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      int[][] queries = new int[k][2];
      for(int i=0; i<k; i++){
          String line = br.readLine();
          queries[i][0] = Integer.parseInt(line.split(" ")[0]);
          queries[i][1] = Integer.parseInt(line.split(" ")[1]);
      }
      
      // Creating the graph
      ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
      for(int i=0; i<n; i++){
          adjList.add(new ArrayList<>());
      }
      
      for(int i=0; i<k; i++){
          int src = queries[i][0];
          int des = queries[i][1];
          adjList.get(src).add(des);
          adjList.get(des).add(src);
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n];
      for(int i=0; i<n; i++){
          if(visited[i]==false){
              ArrayList<Integer> comp = new ArrayList<>();
              dfs(adjList, visited, comp, i);
              comps.add(comp);
          }
      }
      int pairs = 0;
      for(int i=0; i<comps.size(); i++){
          for(int j=i+1; j<comps.size(); j++){
              pairs+=comps.get(i).size()*comps.get(j).size();
          }
      }
      System.out.println(pairs);
   }

}