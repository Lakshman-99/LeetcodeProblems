from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0

        writer = 2
        for reader in range(2, len(nums)):
            if nums[reader] != nums[writer-2]:
                nums[writer] = nums[reader]
                writer += 1

        return writer


sol = Solution()
print(sol.removeDuplicates([0,0,1,1,1,2,2,3,3,4]))