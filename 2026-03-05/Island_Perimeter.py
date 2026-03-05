from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        perimeter = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j]:
                    perimeter += 4

                    if i > 0 and grid[i-1][j]:
                        perimeter -= 2

                    if j > 0 and grid[i][j-1]:
                        perimeter -= 2

        return perimeter


sol = Solution()
print(sol.islandPerimeter([[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]))