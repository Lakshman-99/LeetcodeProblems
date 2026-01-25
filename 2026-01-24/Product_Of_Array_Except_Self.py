from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        n = len(nums)
        prod = 1
        prefix = [1] * n
        for i in range(n):
            prefix[i] = prod
            prod *= nums[i]

        prod = 1
        for i in range(n-1, -1, -1):
            prefix[i] *= prod
            prod *= nums[i]

        return prefix


sol = Solution()
print(sol.productExceptSelf([1,2,3,4,5]))