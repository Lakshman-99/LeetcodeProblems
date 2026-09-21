from collections import deque


class Solution:
    def shortestPathAllKeys(self, grid: list[str]) -> int:
        m, n = len(grid), len(grid[0])
        
        keys = 0
        for i in range(m):
            for j in range(n):
                if 'a' <= grid[i][j] <= 'z':
                    keys += 1

        grid[0][0] = "#"



sol = Solution()
print(sol.shortestPathAllKeys(["@..aA","..B#.","....b"]))