from functools import cache
from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = nums[0]
        cur_prod = 1
        for num in nums:
            cur_prod *= num
            ans = max(ans, cur_prod, num)
            if cur_prod == 0:
                cur_prod = 1

        return ans


sol = Solution()
print(sol.maxProduct([2,-5,-2,-4,3]))