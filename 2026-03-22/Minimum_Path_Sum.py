from functools import cache
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        INT_MAX = (1 << 31) - 1
        prev = [INT_MAX] * n

        for i in range(m):
            cur = list(grid[i])
            for j in range(n):
                if i == 0 and j == 0:
                    continue

                cur[j] += min(prev[j], cur[j-1] if j-1 >= 0 else INT_MAX)

            prev = cur

        return prev[n-1]

    def minPathSum2(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(i, j):
            if i < 0 or j < 0:
                return float('inf')

            if i == 0 and j == 0:
                return grid[0][0]

            return grid[i][j] + min(dfs(i-1, j), dfs(i, j-1))

        return dfs(m-1, n-1)


sol = Solution()
print(sol.minPathSum([[1,3,111],[1,5,111],[4,2,1]]))