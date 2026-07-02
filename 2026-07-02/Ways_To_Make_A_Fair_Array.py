from typing import List


class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        te = to = 0

        for i, num in enumerate(nums):
            if i % 2:
                to += num
            else:
                te += num

        eve = odd = ans = 0
        for i, num in enumerate(nums):
            if i % 2:
                to -= num
            else:
                te -= num

            if eve + to == odd + te:
                ans += 1

            if i % 2:
                odd += num
            else:
                eve += num

        return ans


sol = Solution()
print(sol.waysToMakeFair([2,1,6,4]))