from functools import cache


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        prev = [0] * n
        prev[0] = 1

        for i in range(m):
            cur = [0] * n
            for j in range(n):
                if i == 0 or j == 0:
                    cur[j] = 1
                    continue

                cur[j] = cur[j-1] + prev[j]

            prev = cur

        return prev[n-1]

    def uniquePaths2(self, m: int, n: int) -> int:
        dp = [[0] * (n+1) for _ in range(m+1)]
        dp[1][1] = 1

        for i in range(1, m+1):
            for j in range(1, n+1):
                if i == 1 and j == 1:
                    continue

                dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[m][n]


sol = Solution()
print(sol.uniquePaths(3, 7))