from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def dfs(row, col):
            if 0 <= row < m and 0 <= col < n and grid[row][col] == '1':
                grid[row][col] = '0'

                dfs(row+1, col)
                dfs(row, col+1)
                dfs(row-1, col)
                dfs(row, col-1)

        island = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(i, j)
                    island += 1

        return island


sol = Solution()
print(sol.numIslands([
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]))