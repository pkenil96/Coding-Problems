class L785IsGraphBipartite {
    // we need to color the graph with 2 colors in such a way that no two nodes
    // share the same color, if such a coloring is possible, then the graph is bipartite,
    // else it is not
    private static boolean bfsColoring(int[][] graph, boolean[] visited, boolean[] color, int vertex){
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        visited[vertex] = true;
        // we can be assured that vertex can be colored with color=true without
        // any conflicts as this will be the first node that is being colored
        // the only other possibility is if there are more than one components in the graph
        // then the function would have been called more than once but even then color=true
        // for vertex would not create any problem as it would be the first node of that
        // particular component
        color[vertex] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            // we are visiting each unvisited neighbour of curr and 
            // coloring it with the color opposite to curr's color
            // while doing so, in case we find a node which has already been
            // colored with the same color as curr, that means there is an
            // odd length cycle in the graph and the graph is not bipartite
            for(int node: graph[curr]){
                if(visited[node] == false){
                    q.add(node);
                    visited[node] = true;
                    color[node] = !color[curr];
                } else if(color[node] == color[curr]){
                    // odd length cycle detected, hence not bipartite
                    return false;
                }
            }
        }
        // the component starting with vertex was colored with no color
        // conflicts hence this component is bipartite
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        // since we need to color the graph with just 2 color,
        // and also, we need to toggle between colors, boolean
        // works out the best in the situation
        boolean[] color = new boolean[n];
        // we call the coloring algorithm on each node just to make sure
        // that we color each node even when the graph is diconnected
        for(int i=0; i<graph.length; i++){
            if(visited[i] == false){
                boolean result = bfsColoring(graph, visited, color, i);
                // in case we find even a single instance wherein the coloring
                // policy gets violated, we conclude that graph is not bipartite
                if(result == false){
                    return false;
                }
            }
        }
        // if the code reach till here it implies that we were able to color the graph
        // with our required constraints which proves that the graph is bipartite
        return true;
    }
}