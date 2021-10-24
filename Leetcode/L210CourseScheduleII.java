class L210CourseScheduleII {
    
    public static boolean allInOne(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recVisited, int vertex, Stack<Integer> stack){
        recVisited[vertex] = true;
        visited[vertex] = true;
        for(int node: adjList.get(vertex)){
            if(recVisited[node] == true) return true;
            if(visited[node] == false){
                if(allInOne(adjList, visited, recVisited, node, stack) == true){
                    return true;
                }   
            }
        }
        stack.push(vertex);
        recVisited[vertex] = false;
        return false;
    }
    
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recVisited, int vertex){
        recVisited[vertex] = true;
        visited[vertex] = true;
        for(int node: adjList.get(vertex)){
            if(recVisited[node] == true) return true;
            if(visited[node] == false){
                if(hasCycle(adjList, visited, recVisited, node) == true){
                    return true;
                }   
            }
        }
        recVisited[vertex] = false;
        return false;
    }
    
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adjList){
        int N = adjList.size();
        boolean[] visited = new boolean[N];
        boolean[] recVisited = new boolean[N];
        for(int i=0; i<N; i++){
            if(visited[i] == false){
                if(hasCycle(adjList, visited, recVisited, i) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void topologicalSort(int vertex, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack){
        visited[vertex] = true;
        for(int neighbor: adjList.get(vertex)){
            if(visited[neighbor] == false){
                topologicalSort(neighbor, adjList, visited, stack);
            }
        }
        stack.push(vertex);
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // first we need to form a graph from the given prerequisites
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        // forming the graph by adding edges
        for(int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][0];
            int des = prerequisites[i][1];
            adjList.get(src).add(des);
            adjList.set(src, adjList.get(src));
        }
        
        int[] output = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recVisited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(visited[i] == false){
                if(allInOne(adjList, visited, recVisited, i, stack) == true){
                    return new int[0];
                }
            }
        }
        int index = stack.size()-1;
        while(!stack.isEmpty() && index >= 0){
            output[index--] = stack.pop();
        }
        return output;
        /*
        // now we check if cycle exists in the graph or not
        boolean cycleExists = hasCycle(adjList);
        // if there is a cycle, return empty array
        if(cycleExists){
            return new int[0];
        }
        // else find the topolofical sorted order of courses
        int[] output = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(visited[i] == false){
                topologicalSort(i, adjList, visited, stack);
            }
        }
        //System.out.println(stack.toString());
        int index = stack.size()-1;
        while(!stack.isEmpty() && index >= 0){
            output[index--] = stack.pop();
        }
        return output;*/
    }
}