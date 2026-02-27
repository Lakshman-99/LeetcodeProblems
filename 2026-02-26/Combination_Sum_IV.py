from functools import cache
from typing import List


class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        @cache
        def dfs(cur_tar):
            if cur_tar == 0:
                return 1

            ans = 0
            for num in nums:
                if cur_tar - num < 0:
                    continue

                ans += dfs(cur_tar - num)

            return ans

        dp = [0] * (target+1)
        dp[0] = 1

        for i in range(target+1):
            for num in nums:
                if i - num < 0:
                    continue

                dp[i] += dp[i-num]

        return dp[target]


sol = Solution()
print(sol.combinationSum4([1,2,3], 4))