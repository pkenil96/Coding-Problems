import java.util.*;

class LevelByLevelBfsOnGraph{

	public static void levelByLevelBFS(List<List<Integer>> graph, int src){
		int n = graph.size();
		int distance=0;
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		boolean[] visited = new boolean[n];
		visited[src] = true;
		System.out.println("Node: "+src+", Distance from src: "+distance);

		while(!q.isEmpty()){
			distance++;
			int size = q.size();
			while(size > 0){
				size--;
				int curr = q.poll();
				for(int node: graph.get(curr)){
					if(visited[node] == false){
						System.out.println("Node: "+node+", Distance from src: "+distance);
						visited[node] = true;
						q.add(node);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList<>();
		graph.add(0, Arrays.asList(1,3));
		graph.add(1, Arrays.asList(0,2));
		graph.add(2, Arrays.asList(1,3));
		graph.add(3, Arrays.asList(0,2,4));
		graph.add(4, Arrays.asList(3,5,6));
		graph.add(5, Arrays.asList(4,6));
		graph.add(6, Arrays.asList(4,5));

		// let 0 be the source vertex
		levelByLevelBFS(graph, 0);
	}
}