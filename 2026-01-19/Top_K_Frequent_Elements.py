from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or k <= 0:
            return []

        if len(nums) == k:
            return list(set(nums))

        map = defaultdict


sol = Solution()
print(sol.topKFrequent([0,2,0,2,1,1,0], 2))