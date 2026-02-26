from functools import cache
from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        @cache
        def dfs(i):
            res = 1
            for j in range(i+1, len(nums)):
                if nums[j] > nums[i]:
                    res = max(res, 1 + dfs(j))

            return res

        return max(dfs(i) for i in range(len(nums)))


sol = Solution()
print(sol.lengthOfLIS([4,10,4,3,8,9]))