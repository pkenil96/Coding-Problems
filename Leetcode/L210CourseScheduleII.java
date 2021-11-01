class L210CourseScheduleII {
    
    public boolean cycleExists(int node, boolean[] visited, boolean[] path, List<List<Integer>> adjList, Stack<Integer> stack){
        visited[node] = true;
        path[node] = true;
        for(int curr: adjList.get(node)){
            if(path[curr]==true){
                return true; //cycle exists
            }
            if(visited[curr] == false && cycleExists(curr, visited, path, adjList, stack) == true){
                return true;
            }
        }
        stack.push(node);
        path[node] = false;
        return false;
    }
    
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][0];
            int des = prerequisites[i][1];
            adjList.get(src).add(des);
        }
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(visited[i] == false && cycleExists(i, visited, path, adjList, stack)){
                return new int[0];
            }
        }
        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}