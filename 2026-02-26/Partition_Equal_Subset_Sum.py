from functools import cache
from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False

        target = total // 2
        @cache
        def dfs(i, cur_sum):
            if cur_sum == 0:
                return True

            if cur_sum < 0 or i == len(nums):
                return False

            return dfs(i+1, cur_sum-nums[i]) or dfs(i+1, cur_sum)

        n = len(nums)
        dp = [[False] * (target+1) for _ in range(n+1)]
        for i in range(n+1):
            dp[i][0] = True

        for i in range(n-1,-1,-1):


        return dfs(0, target)

sol = Solution()
print(sol.canPartition([3,3,6,8,16,16,16,18,20]))