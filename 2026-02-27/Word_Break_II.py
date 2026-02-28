import math
from functools import cache
from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        ans = []
        wordDict = set(wordDict)

        def dfs(i, cur_list):
            if i == len(s):
                ans.append(" ".join(cur_list))
                return

            for word in wordDict:
                if s.startswith(word, i):
                    cur_list.append(word)
                    dfs(i+len(word), cur_list)
                    cur_list.pop()

        dfs(0, [])
        return ans


sol = Solution()
print(sol.wordBreak("pineapplepenapple", ["apple","pen","applepen","pine","pineapple"]))