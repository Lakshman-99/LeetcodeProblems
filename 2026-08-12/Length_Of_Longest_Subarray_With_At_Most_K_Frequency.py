from collections import defaultdict
from typing import List


class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        freq = defaultdict(int)

        ans = mx = l = 0
        for r in range(n):
            freq[nums[r]] += 1
            mx = max(mx, freq[nums[r]])

            while mx > k:
                freq[nums[l]] -= 1
                l += 1
                if nums[l-1] == nums[r]:
                    mx -= 1
                    break

            ans = max(ans, r - l + 1)

        return ans


sol = Solution()
print(sol.maxSubarrayLength([1,2,3,1,2,3,3,2], 2))