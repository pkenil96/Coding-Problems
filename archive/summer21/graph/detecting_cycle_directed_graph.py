# representing graph as adjacency list

class Graph:
    def __init__(self, n):
        self.n = n
        self.edges = {}

    def addEdge(self, src, des):
        self.edges[src] = des

    def bfs(self):
        pass

    def dfs(self):
        pass

G = Graph(4)
G.addEdge(1, 2)
G.addEdge(1, 4)
G.addEdge(3, 1)
G.addEdge(3, 4)
G.addEdge(4, 2)