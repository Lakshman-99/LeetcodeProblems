from typing import List


class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        mx = mn = nums[0]
        cur_max = cur_min = total = 0

        for num in nums:
            total += num
            cur_max = max(cur_max + num, num)
            mx = max(mx, cur_max)

            cur_min = min(cur_min + num, num)
            mn = min(mn, cur_min)

        if total == cur_min:
            return mx

        return max(mx, total - mn)


sol = Solution()
print(sol.maxSubarraySumCircular([2,-2,2,7,8,0]))