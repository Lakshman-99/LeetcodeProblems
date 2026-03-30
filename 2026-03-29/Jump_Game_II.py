from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        l = r = min_jump = 0

        while r < n - 1:
            mx = 0
            for i in range(l, r+1):
                mx = max(mx, i + nums[i])

            l = r + 1
            r = mx
            min_jump += 1

        return min_jump


sol = Solution()
print(sol.jump([2,3,1,1,4]))