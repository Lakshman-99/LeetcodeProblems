from collections import defaultdict
from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0

        writer = 0
        for reader in range(len(nums)):
            if nums[reader] != val:
                nums[writer] = nums[reader]
                writer += 1

        return writer




sol = Solution()
print(sol.removeElement([2], 2))