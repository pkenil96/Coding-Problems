def visitAndMarkNeighbours(grid, i, j):
	if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]!='1':
		return
	# mark the current node as visited
	grid[i][j]='2'
	# visit all four neighbours of the current node and mark the 1's as visited
	visitAndMarkNeighbours(grid, i-1, j)
	visitAndMarkNeighbours(grid, i+1, j)
	visitAndMarkNeighbours(grid, i, j-1)
	visitAndMarkNeighbours(grid, i, j+1)
	return

def numberOfIslands(grid):
	if grid is None or len(grid)==0:
		return 0
	
	islandCount = 0
	for i in range(len(grid)):
		for j in range(len(grid[0])):
			if grid[i][j] == '1':
				islandCount+=1
				# This function performs dfs on current cell
				# and marks all the neighbouring cells that has 1 in it
				visitAndMarkNeighbours(grid, i, j)
	
	return islandCount
