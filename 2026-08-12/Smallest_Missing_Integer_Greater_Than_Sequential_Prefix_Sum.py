from typing import List


class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        mx = nums[0]
        i, n = 1, len(nums)
        while i < n and nums[i] == nums[i-1] + 1:
            mx += nums[i]
            i += 1

        uni = set(nums)
        while mx in uni:
            mx += 1

        return mx


sol = Solution()
print(sol.missingInteger([46,8,2,4,1,4,10,2,4,10,2,5,7,3,1]))