import java.util.*;

class L207CourseSchedule {
    
    public boolean cycleFound(int vertex, boolean[] overallVisited, boolean[] pathVisited, List<List<Integer>> adjList){
        overallVisited[vertex] = true;
        pathVisited[vertex] = true;
        for(int node: adjList.get(vertex)){
            if(pathVisited[node] == true){
                return true;
            }
            if(overallVisited[node] == false && cycleFound(node, overallVisited, pathVisited, adjList) == true){
                return true;
            }
        }
        pathVisited[vertex] = false;
        return false;
    }
    
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][0];
            int des = prerequisites[i][1];
            adjList.get(src).add(des);
        }
        boolean[] overallVisited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for(int i=0; i<n ; i++){
            if(overallVisited[i] == false){
                if(cycleFound(i, overallVisited, pathVisited, adjList) == true){
                    return false;
                }
            }
        }
        return true;
    }
}