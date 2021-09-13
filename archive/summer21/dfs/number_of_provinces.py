from collections import deque


def bfsUtil(vertex, matrix, visited):
    '''
        this function takes a vertex and visits all its neighbors in breath first manner
    '''
    queue = deque()
    queue.append(vertex)
    while queue:
        curr = queue.popleft()
        visited.add(curr)
        for i in range(0, len(matrix[0])):
            if matrix[curr - 1][i] == 1 and i + 1 not in visited:
                queue.append(i + 1)
                visited.add(i + 1)


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        '''
            We perform the version of bfs that includes the disconnected components of the graph and count the number of times bfsutil function is being called. the count is our required answer.
        '''
        n = len(isConnected)
        visited = set()
        numberOfProvinces = 0
        for i in range(n):
            if i + 1 not in visited:
                bfsUtil(i + 1, isConnected, visited)
                numberOfProvinces += 1
        return numberOfProvinces
