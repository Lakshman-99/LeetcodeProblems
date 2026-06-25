from typing import List


class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        ans = 0
        n = len(nums)
        for i in range(n):
            tc = 0
            for j in range(i, n):
                if nums[j] == target:
                    tc += 1

                if 2 * tc > j - i + 1:
                    ans += 1

        return ans

    def countMajoritySubarrays2(self, nums: List[int], target: int) -> int:
        l = tc = ans = 0
        for r in range(len(nums)):
            if nums[r] == target:
                tc += 1
                ans += 1

            while tc > (r - l + 1) - tc:
                ans += 1
                if nums[l] == target:
                    tc -= 1
                l += 1

        return ans


sol = Solution()
print(sol.countMajoritySubarrays([1,2,2,3], 2))