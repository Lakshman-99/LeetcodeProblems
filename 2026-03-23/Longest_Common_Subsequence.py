from functools import cache


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if len(text1) > len(text2):
            text1, text2 = text2, text1

        m, n = len(text1), len(text2)
        prev = [0] * (n + 1)

        for i in range(1, m+1):
            cur = [0] * (n + 1)
            for j in range(1, n+1):
                if text1[i-1] == text2[j-1]:
                    cur[j] = 1 + prev[j-1]
                else:
                    cur[j] += max(prev[j], cur[j-1])
            prev = cur

        return prev[n]

    def longestCommonSubsequence2(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)

        @cache
        def dfs(i, j):
            if i < 0 or j < 0:
                return 0

            common = 0
            if text1[i] == text2[j]:
                common = 1 + dfs(i-1, j-1)
            else:
                common += max(dfs(i-1, j), dfs(i, j - 1))

            return common

        return dfs(m-1, n-1)


sol = Solution()
print(sol.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"))