from functools import cache


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        if not s and p.count("*") == n:
            return True

        @cache
        def dfs(i, j):
            if i >= m:
                return j == n

            if j >= n:
                return False

            if p[j] == '*':
                return dfs(i, j+1) or dfs(i+1, j) or dfs(i+1, j+1)
            elif p[j] == '?' or s[i] == p[j]:
                return dfs(i+1, j+1)

            return False

        return dfs(0, 0)


sol = Solution()
print(sol.isMatch("abcabczzzde", "*abc???de*"))