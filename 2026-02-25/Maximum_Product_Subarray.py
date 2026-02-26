from functools import cache
from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = nums[0]
        cur_min, cur_max = 1, 1
        for num in nums:
            tmp = cur_max * num
            cur_max = max(tmp, num, num * cur_min)
            cur_min = min(tmp, num, num * cur_min)
            ans = max(ans, cur_max)

        return ans


sol = Solution()
print(sol.maxProduct([2,-5,-2,-4,3]))