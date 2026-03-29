from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0

        sm = 0
        mx_sum = -1 * (1 << 31)

        for num in nums:
            sm += num
            mx_sum = max(mx_sum, sm)

            if sm < 0:
                sm = 0

        return mx_sum


sol = Solution()
print(sol.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))