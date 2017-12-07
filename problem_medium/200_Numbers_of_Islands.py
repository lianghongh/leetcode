class Solution:
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        height=len(grid)
        if height==0:
            return 0
        width=len(grid[0])
        count=0
        def DFS(i,j):
            if grid[i][j]:
                grid[i][j]=0
                if i>0:
                    DFS(i-1,j)
                if j>0:
                    DFS(i,j-1)
                if i<height-1:
                    DFS(i+1,j)
                if j<width-1:
                    DFS(i,j+1)

        for i in range(height):
            for j in range(width):
                if grid[i][j]:
                    count+=1
                    DFS(i,j)

        return count