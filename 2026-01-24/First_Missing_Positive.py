from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if not nums:
            return 1

        # optimal soln
        # uni = set(nums)
        # n = len(nums)
        # for i in range(1, n+1):
        #     if i not in uni:
        #         return i

        #optimized
        # n = len(nums)
        # for i in range(n):
        #     if nums[i] < 0:
        #         nums[i] = 0
        #
        # for i in range(n):
        #     val = abs(nums[i])
        #     if 1 <= val <= n:
        #         if nums[val - 1] > 0:
        #             nums[val - 1] *= -1
        #         elif nums[val - 1] == 0:
        #             nums[val - 1] = -1 * (n+1)
        #
        # for i in range(1, n+1):
        #     if nums[i-1] >= 0:
        #         return i

        # cyclic sort
        n = len(nums)
        for i in range(n):
            while 1 <= nums[i] <= n and nums[i] != nums[nums[i] - 1]:
                pos = nums[i] - 1
                nums[i], nums[pos] = nums[pos], nums[i]

        for i in range(n):
            if nums[i] != i+1:
                return i+1

        return n + 1



sol = Solution()
print(sol.firstMissingPositive([1,2,0]))
print(sol.firstMissingPositive([3,4,-1,1]))
print(sol.firstMissingPositive([7,8,9,11,12]))
