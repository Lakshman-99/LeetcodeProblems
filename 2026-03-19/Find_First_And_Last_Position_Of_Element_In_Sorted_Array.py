from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def bisect(left=False, right=False):
            l, r = 0, len(nums)
            while l < r:
                m = (l + r) // 2
                if (left and nums[m] < target) or (right and nums[m] <= target):
                    l = m + 1
                else:
                    r = m

            return l

        left = bisect(left=True)
        right = bisect(right=True)
        if left < right:
            return [left, right - 1]

        return [-1, -1]


sol = Solution()
print(sol.searchRange([5,7,7,8,8,10], 8))