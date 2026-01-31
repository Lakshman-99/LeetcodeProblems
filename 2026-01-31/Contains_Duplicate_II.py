from collections import defaultdict
from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        curLen = 0
        tracker = defaultdict(int)
        for i, num in enumerate(nums):
            if curLen <= k:
                if num in tracker:
                    return True
                tracker[num] += 1
                curLen += 1

            if curLen > k:
                key = nums[i-k]
                tracker[key] -= 1
                curLen -= 1
                if tracker[key] == 0:
                    tracker.pop(key)

        return False


sol = Solution()
print(sol.containsNearbyDuplicate([1,2,3,1,2,3], 2))