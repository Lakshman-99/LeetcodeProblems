from functools import cache


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        dp = [n - j for j in range(n+1)]

        for i in range(m-1, -1, -1):
            cur = list(dp)
            cur[n] = m - i
            for j in range(n-1, -1, -1):
                if word1[i] == word2[j]:
                    cur[j] = dp[j+1]
                else:
                    cur[j] = 1 + min(dp[j], cur[j+1], dp[j+1])

            dp = cur

        return dp[0]

    def minDistance2(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)

        @cache
        def dfs(i, j):
            if i == m:
                return n - j

            if j == n:
                return m - i

            if word1[i] == word2[j]:
                return dfs(i+1, j+1)

            return 1 + min(dfs(i+1, j), dfs(i, j+1), dfs(i+1, j+1))

        return dfs(0, 0)


sol = Solution()
print(sol.minDistance("ab", "bc"))
print(sol.minDistance("intention", "execution"))