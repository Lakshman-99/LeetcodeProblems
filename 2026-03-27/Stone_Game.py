from functools import cache
from typing import List


class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)

        @cache
        def dfs(i, j):
            if i > j:
                return 0

            alice = (i + j) % 2 == 1
            left = piles[i] if alice else 0
            right = piles[j] if alice else 0
            return max(dfs(i+1, j) + left, dfs(i, j-1) + right)

        total = sum(piles)
        ans = dfs(0, n-1)

        return ans > total - ans


sol = Solution()
print(sol.stoneGame([5,3,4,5]))