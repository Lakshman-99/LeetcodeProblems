from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        ans = l = cur = 0

        for r in range(len(nums)):
            cur += nums[r]

            while cur * (r - l + 1) >= k:
                cur -= nums[l]
                l += 1

            ans += r - l + 1

        return ans


sol = Solution()
print(sol.countSubarrays([2,1,4,3,5], 10))