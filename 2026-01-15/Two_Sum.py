from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [0, 0]

        n = len(nums)

        # brute force - o(n)
        # for i in range(n):
        #     for j in range(i+1, n):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]

        # optimized - o(n)
        seen = {}
        for i, num in enumerate(nums):
            if target - num in seen:
                return [seen[target-num], i]
            seen[num] = i

        return [0, 0]


sol = Solution()
print(sol.twoSum([2,7,11,15], 9))