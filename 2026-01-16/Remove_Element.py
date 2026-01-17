from collections import defaultdict
from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0

        v = 1
        n = len(nums)
        for i in range(n):
            if nums[i] != val:
                continue
                
            while i+v < n and nums[i+v] == val:
                v += 1



sol = Solution()
print(sol.removeElement([3,2,2,3], 3))