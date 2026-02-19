from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False

        target = total // 2
        nums.sort(reverse=True)
        if nums[0] > target:
            return False

        l, r = 0, len(nums)-1

        return True



sol = Solution()
print(sol.canPartition([1,1,2,2]))