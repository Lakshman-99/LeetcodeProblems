from functools import cache


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        l1, l2, l3 = len(s1), len(s2), len(s3)
        if l1 + l2 != l3:
            return False

        dp = [False] * (l2 + 1)
        dp[0] = True

        for i in range(l1 + 1):
            for j in range(l2 + 1):
                k = i + j - 1
                if i > 0 and s3[k] != s1[i-1]:
                    dp[j] = False

                if j > 0 and s3[k] == s2[j-1]:
                    dp[j] |= dp[j-1]

        return dp[l2]

    def isInterleave2(self, s1: str, s2: str, s3: str) -> bool:
        l1, l2, l3 = len(s1), len(s2), len(s3)
        if l1 + l2 != l3:
            return False

        dp = [[False] * (l2 + 1) for _ in range(l1 + 1)]
        dp[0][0] = True

        for i in range(l1 + 1):
            for j in range(l2 + 1):
                k = i + j - 1
                if i > 0 and s3[k] == s1[i-1]:
                    dp[i][j] |= dp[i-1][j]

                if j > 0 and s3[k] == s2[j-1]:
                    dp[i][j] |= dp[i][j-1]

        return dp[l1][l2]

    def isInterleave3(self, s1: str, s2: str, s3: str) -> bool:
        l1, l2, l3 = len(s1), len(s2), len(s3)

        @cache
        def dfs(i, j, k):  # i-> s1, j -> s2, k -> s3
            if k < 0:
                return i == -1 and j == -1

            res = False
            if 0 <= i < l1 and s3[k] == s1[i]:
                res |= dfs(i-1, j, k-1)

            if 0 <= j < l2 and s3[k] == s2[j]:
                res |= dfs(i, j-1, k-1)

            return res

        return dfs(l1-1, l2-1, l3-1)


sol = Solution()
print(sol.isInterleave("a", "b", "a"))