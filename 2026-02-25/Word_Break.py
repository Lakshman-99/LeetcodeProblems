from functools import cache
from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        @cache
        def dfs(i):
            if i == len(s):
                return True

            for word in wordDict:
                if s.startswith(word, i):
                    if dfs(i+len(word)):
                        return True

            return False

        dp = [False] * (len(s) + 1)
        dp[len(s)] = True

        for i in range(len(s)-1, -1, -1):
            for word in wordDict:
                if s.startswith(word, i) and dp[i + len(word)]:
                    dp[i] = True
                    break

        return dp[0]



sol = Solution()
print(sol.wordBreak("catsandog", ["cats","dog","sand","and","catsa"]))

