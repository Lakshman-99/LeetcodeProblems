from functools import cache
from typing import List


class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)

        @cache
        def dfs(alice, i, m):
            if i >= n:
                return 0

            cr_mx = 0
            mx = 0 if alice else float('inf')
            for x in range(1, 2 * m + 1):
                if i + x - 1 >= n:
                    break

                cr_mx += piles[i + x - 1]
                res = dfs(not alice, i + x, max(x, m))
                if alice:
                    mx = max(mx, res + cr_mx)
                else:
                    mx = min(mx, res)

            return mx

        return dfs(True, 0, 1)


sol = Solution()
print(sol.stoneGameII([2,7,9,4,4]))