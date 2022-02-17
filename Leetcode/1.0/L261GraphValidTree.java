class DisjointSet{
    int N;
    Integer[] parent;
    
    DisjointSet(int N){
        this.N = N;
        parent = new Integer[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
    }
    
    void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return;
        }
        parent[pa] = pb;
    }
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    boolean hasCycle(int x, int y){
        return find(x) == find(y);
    }
}

class L261GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        /*
            TWO CASES WHEN GRAPH WILL NOT BE A TREE:
            1. If the graph is disconnected: edges < vertices-1
            2. If the graph has a cycle
        */
        if(edges.length < n-1){
            return false;
        }
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            if(ds.hasCycle(src, des)){
                return false;
            } else {
                ds.union(src, des);
            }
        }
        return true;
    }
}