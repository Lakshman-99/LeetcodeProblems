from typing import List


class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        MOD = 10**9 + 7

        mx = [[0] * n for _ in range(m)]
        mn = [[0] * n for _ in range(m)]
        mx[0][0] = mn[0][0] = grid[0][0]

        for i in range(1, m):
            mx[0][i] = mn[0][i] = grid[0][i] * mx[0][i-1]

        for i in range(1, n):
            mx[i][0] = mn[i][0] = grid[i][0] * mx[i-1][0]

        for i in range(1, m):
            for j in range(1, n):
                val = grid[i][j]

                a = mx[i-1][j] * val
                b = mn[i-1][j] * val
                c = mx[i][j-1] * val
                d = mn[i][j-1] * val

                mx[i][j] = max(a, b, c, d)
                mn[i][j] = min(a, b, c, d)

        ans = mx[m-1][n-1]
        return -1 if ans < 0 else ans % MOD

    def maxProductPath2(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        MOD = 1_000_000_007

        def dfs(i, j):
            if i < 0 or j < 0:
                return 1

            if i == 0 and j == 0:
                return grid[0][0]

            return grid[i][j] * max(dfs(i - 1, j), dfs(i, j - 1))

        max_prod = dfs(m - 1, n - 1)
        return -1 if max_prod < 0 else max_prod % MOD


sol = Solution()
print(sol.maxProductPath([[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]))