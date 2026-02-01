from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        total = sum(nums)
        n = len(nums)

        if total < target:
            return 0

        if total == target:
            return len(nums)

        rSum = l = 0
        minLen = n
        for r in range(n + 1):
            while rSum >= target:
                minLen = min(minLen, r - l)
                rSum -= nums[l]
                l += 1

            if r < n:
                rSum += nums[r]

        return minLen


sol = Solution()
print(sol.minSubArrayLen(15, [5,1,3,5,10,7,4,9,2,8]))