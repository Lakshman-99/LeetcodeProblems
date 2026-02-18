from collections import Counter
from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def is_palindrome(l, r):
            while l <= r:
                if s[l] != s[r]:
                    return False

                l += 1
                r -= 1

            return True

        def dfs(i, cur_list):
            if i == len(s):
                res.append(cur_list[:])
                return

            for j in range(i, len(s)):
                if is_palindrome(i, j):
                    cur_list.append(s[i : j+1])
                    dfs(j+1, cur_list)
                    cur_list.pop()

        dfs(0, [])
        return res


sol = Solution()
print(sol.partition("aab"))