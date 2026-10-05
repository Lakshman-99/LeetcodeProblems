from functools import cache


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        i = j = 0
        star_i = star_j = -1
        m, n = len(s), len(p)

        while i < m:
            if j < n and (p[j] == '?' or p[j] == s[i]):
                i += 1
                j += 1
            elif j < n and p[j] == '*':
                star_i = i
                star_j = j
                j += 1
            elif star_j != -1:
                i = star_i + 1
                j = star_j + 1
                star_i += 1
            else:
                return False

        while j < n and p[j] == '*':
            j += 1

        return j == n

    def isMatch2(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [[False] * (n + 1) for _ in range(m + 1)]

        for i in range(m, -1, -1):
            for j in range(n, -1, -1):
                if i == m:
                    dp[i][j] = j == n or (p[j] == "*" and dp[i][j+1])
                elif j == n:
                    dp[i][j] = False
                elif p[j] == '*':
                    dp[i][j] = dp[i][j+1] or dp[i+1][j]
                elif p[j] == '?' or s[i] == p[j]:
                    dp[i][j] = dp[i+1][j+1]

        return dp[0][0]

    def isMatch3(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)

        @cache
        def dfs(i, j):
            if i >= m:
                return j == n or p[j:] == "*" * (n - j)

            if j >= n:
                return False

            if p[j] == '*':
                return dfs(i, j+1) or dfs(i+1, j)
            elif p[j] == '?' or s[i] == p[j]:
                return dfs(i+1, j+1)

            return False

        return dfs(0, 0)


sol = Solution()
print(sol.isMatch("acdcb", "a*c?b"))