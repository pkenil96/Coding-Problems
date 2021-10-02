class L785IsGraphBipartite {
    
    private static boolean bfsColoring(int[][] graph, boolean[] visited, boolean[] color, int vertex){
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        visited[vertex] = true;
        color[vertex] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int node: graph[curr]){
                if(visited[node] == false){
                    q.add(node);
                    visited[node] = true;
                    color[node] = !color[curr];
                } else if(color[node] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        for(int i=0; i<graph.length; i++){
            if(visited[i] == false){
                boolean result = bfsColoring(graph, visited, color, i);
                if(result == false){
                    return false;
                }
            }
        }
        return true;
    }
}