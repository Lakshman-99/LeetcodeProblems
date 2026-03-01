from collections import defaultdict
from functools import cache
from typing import List


class Solution:
    def isValidPalindrome(self, s: str, k: int) -> bool:
        @cache
        def dfs(l, r, cur_k) -> bool:
            if cur_k < 0:
                return False

            if l >= r:
                return True

            if s[l] == s[r]:
                return dfs(l+1, r-1, cur_k)

            return dfs(l+1, r, cur_k-1) or dfs(l, r-1, cur_k-1)

        return dfs(0, len(s)-1, k)


sol =Solution()
print(sol.isValidPalindrome("abcdxeca", 3))