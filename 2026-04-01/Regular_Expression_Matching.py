from functools import cache


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [False] * (n + 2)
        dp[n] = True

        for i in range(m, -1, -1):
            cur = [False] * (n + 2)
            cur[n] = i == m
            for j in range(n-1, -1, -1):
                is_match = i < m and (p[j] == '.' or s[i] == p[j])
                if j + 1 < n and p[j + 1] == '*':
                    cur[j] = cur[j+2] or (is_match and dp[j])
                    continue

                if is_match:
                    cur[j] = dp[j+1]

            dp = cur

        return dp[0]

    def isMatch2(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [[False] * (n + 2) for _ in range(m + 1)]

        for i in range(m, -1, -1):
            for j in range(n, -1, -1):
                if j == n:
                    dp[i][j] = i == m
                    continue

                is_match = i < m and (p[j] == '.' or s[i] == p[j])
                if j + 1 < n and p[j + 1] == '*':
                    dp[i][j] = dp[i][j+2] or (is_match and dp[i+1][j])
                    continue

                if is_match:
                    dp[i][j] = dp[i+1][j+1]

        return dp[0][0]

    def isMatch3(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)

        @cache
        def dfs(i, j):
            if j == n:
                return i == m

            is_match = i < m and (p[j] == '.' or s[i] == p[j])
            if j+1 < n and p[j+1] == '*':
                return dfs(i, j+2) or (is_match and dfs(i+1, j))

            if is_match:
                return dfs(i+1, j+1)

            return False

        return dfs(0, 0)


sol = Solution()
# print(sol.isMatch("aaaaa", "a*a"))
# print(sol.isMatch("aaa", "ab*ac*av*"))
print(sol.isMatch("ab", ".*c"))
