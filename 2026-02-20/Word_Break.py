from functools import cache
from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        @cache
        def dfs(index, segment):
            if not segment:
                return True

            for i in range(index, len(wordDict)):
                temp = segment
                segment = segment.replace(wordDict[i], "")

                if dfs(i + 1, segment):
                    return True

                segment = temp

            return False

        return dfs(0, s)


sol = Solution()
print(sol.wordBreak("catsandog", ["cats","dog","sand","and","cat"]))