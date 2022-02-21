import java.util.*;

class TopologicalSort {
        
    public static void topologicalSort(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        for(int curr: adj.get(node)){
            if(visited[curr] == false){
                topologicalSort(curr, adj, visited, stack);
            }
        }
        stack.push(node);
    }
    
    //Function to return list containing vertices in Topological order. 
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] output = new int[V];
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                topologicalSort(i, adj, visited, stack);
            }
        }
        int index = 0;
        while(!stack.isEmpty()){
            output[index] = stack.pop();
            index++;
        }
        //System.out.println(Arrays.toString(output));
        return output;
    }
}
