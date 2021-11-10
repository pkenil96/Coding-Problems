public class DisjointSet{
	
	private int N;
	private int[] parent;

	public DisjointSet(){
		N=10000;
		this.parent = new int[N];
		for(int i=0; i<N; i++){
			parent[i] = i;
		}
	}

	public DisjointSet(int N){
		this.N=N;
		this.parent = new int[N];
		for(int i=0; i<N; i++){
			parent[i] = i;
		}
	}

	public void union(int a, int b){
		int pa = find(a);
		int pb = find(b);
		if(pa == pb){
			return;
		}
		parent[pa] = pb;
	}

	public int find(int x){
		if(parent[x] != x){
			parent[x] = find(x);
		}
		return parent[x];
	}

	public boolean formsCycle(int a, int b){
		return find(a) == find(b);
	}
}