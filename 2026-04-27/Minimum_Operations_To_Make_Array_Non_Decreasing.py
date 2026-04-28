import heapq


class Solution:
    def minOperations(self, nums: list[int]) -> int:
        return sum(max(0, nums[i-1] - nums[i]) for i in range(1, len(nums)))


sol = Solution()
print(sol.minOperations([7,26,2,25,27]))
print(sol.minOperations([10,24,1,11,3]))