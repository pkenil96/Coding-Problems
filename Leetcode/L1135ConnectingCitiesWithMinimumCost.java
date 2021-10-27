class DisjointSet{
    
    static int[] parent;
    
    public DisjointSet(int[][] edges, int n){
        this.parent = new int[n+1];
        for(int i=0; i<=n; i++){
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
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean isCycle(int a, int b){
        return find(a) == find(b);
    }
    
}

class L1135ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        // sorting connections wrt edge weight
        int minCost=0;
        Arrays.sort(connections, (a, b) -> a[2]-b[2]);
        // we first form the disjoint set using given edges
        int edgeCount=0;
        DisjointSet ds = new DisjointSet(connections, n);
        
        for(int i=0; i<connections.length; i++){
            int src = connections[i][0];
            int des = connections[i][1];
            int cost = connections[i][2];
            
            if(ds.isCycle(src, des)){
                continue;
            } else {
                ds.union(src, des);
                edgeCount++;
                minCost += cost;
            }
            if(edgeCount == n-1){
                return minCost;
            }
            
        }
        return -1;
    }
}