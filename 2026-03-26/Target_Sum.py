from functools import cache
from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        s = sum(nums)

        dp = [0] * (2 * s + 1)
        dp[target + s] = 1

        for i in range(n):
            cur = [0] * (2 * s + 1)
            for t in range(2 * s + 1):
                left = t - nums[i]
                right = t + nums[i]
                if left >= 0:
                    cur[t] += dp[left]

                if right <= 2 * s:
                    cur[t] += dp[right]

            dp = cur

        return dp[s]


    def findTargetSumWays2(self, nums: List[int], target: int) -> int:
        n = len(nums)

        @cache
        def dfs(i, acc):
            if i < 0:
                return 1 if acc == target else 0

            return dfs(i-1, acc - nums[i]) + dfs(i-1, acc + nums[i])

        return dfs(n-1, 0)


sol = Solution()
print(sol.findTargetSumWays([1,1,1,1,1], 3))