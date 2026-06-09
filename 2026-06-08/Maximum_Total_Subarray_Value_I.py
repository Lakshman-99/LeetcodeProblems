from typing import List


class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        return (max(nums) - min(nums)) * k


sol = Solution()
print(sol.maxTotalValue([4,2,5,1], 3))