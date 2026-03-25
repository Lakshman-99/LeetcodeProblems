from functools import cache
from typing import List


class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        total = sum(stones)
        target = total // 2
        dp = [0] * (target + 1)

        for s in stones:
            for t in range(target, s-1, -1):
                dp[t] = max(dp[t], dp[t - s] + s)

        return total - 2 * dp[target]

    def lastStoneWeightII2(self, stones: List[int]) -> int:
        total = sum(stones)
        target = (total + 1) // 2

        @cache
        def dfs(i, cur_sum):
            if i < 0 or cur_sum >= target:
                return abs(2 * cur_sum - total)

            return min(dfs(i-1, cur_sum), dfs(i-1, cur_sum + stones[i]))

        return dfs(len(stones)-1, 0)


sol = Solution()
print(sol.lastStoneWeightII([2,7,4,1,8,1]))