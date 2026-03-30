from functools import cache


class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        s_len, t_len = len(s), len(t)
        dp = [0] * (t_len + 1)
        dp[t_len] = 1

        for i in range(s_len-1, -1, -1):
            cur = list(dp)
            for j in range(t_len-1, -1, -1):
                if s[i] == t[j]:
                    cur[j] += dp[j+1]

            dp = cur

        return dp[0]

    def numDistinct2(self, s: str, t: str) -> int:
        s_len, t_len = len(s), len(t)

        @cache
        def dfs(i, j):
            if j == t_len:
                return 1

            if i == s_len:
                return 0

            res = 0
            if s[i] == t[j]:
                res += dfs(i+1, j+1)

            return res + dfs(i+1, j)

        return dfs(0, 0)


sol = Solution()
print(sol.numDistinct("babgbag", "bag"))