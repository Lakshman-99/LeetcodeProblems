import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        while l <= r:
            mid = l + (r - l) // 2
            time = 0
            for pile in piles:
                time += math.ceil(pile / mid)

            if time > h:
                l = mid + 1
            else:
                r = mid - 1

        return l


sol = Solution()
print(sol.minEatingSpeed([30,11,23,4,20], 6))
