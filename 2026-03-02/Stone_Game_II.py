from functools import cache
from typing import List


class Solution:
    def stoneGameII(self, piles: List[int]) -> bool:
        @cache
        def dfs(alice, ind, m):
            if ind >= len(piles):
                return 0

            cur_sum = 0
            max_sum = 0 if alice else float('inf')
            for x in range(1, 2 * m + 1):
                if ind + x - 1 >= len(piles):
                    break

                cur_sum += piles[ind + x - 1]
                res = dfs(not alice, ind + x, max(m, x))
                if alice:
                    max_sum = max(max_sum, res + cur_sum)
                else:
                    max_sum = min(max_sum, res)

            return max_sum

        return dfs(True,0, 1)


sol = Solution()
print(sol.stoneGameII([2,7,9,4,4]))