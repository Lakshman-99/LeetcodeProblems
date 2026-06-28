import math
from typing import List


class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        def kadane(arr):
            mx = min(arr)
            cur = 0

            for num in arr:
                cur += num
                mx = max(mx, cur)

                if cur < 0:
                    cur = 0

            return mx

        mul = [n * k for n in nums]
        div = [num // k if num > 0 else math.ceil(num / k) for num in nums]

        return max(kadane(mul), kadane(div))


sol = Solution()
print(sol.maxSubarraySum([1,-2,3,4,-5], 5))
print(sol.maxSubarraySum([-5,-4,-3], 2))
