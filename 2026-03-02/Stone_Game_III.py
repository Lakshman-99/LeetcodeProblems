from functools import cache
from typing import List


class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        def dfs(ind):
            if ind >= len(stoneValue):
                return 0

            cur_sum = 0
            res = float('-inf')
            for i in range(ind, ind + 3):
                if i >= len(stoneValue):
                    break

                cur_sum += stoneValue[i]
                res = max(res, cur_sum - dfs(i+1))

            return res

        ans = dfs(0)

        return "Tie" if ans == 0 else "Alice" if ans > 0 else "Bob"


sol = Solution()
print(sol.stoneGameIII([2,4,1,10,13]))