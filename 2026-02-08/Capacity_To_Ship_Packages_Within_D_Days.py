import math
from typing import List


class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)

        def canShip(cap):
            ship = 1
            res = cap
            for w in weights:
                if res - w < 0:
                    ship += 1
                    res = cap
                res -= w

            return ship <= days

        while l <= r:
            cap = l + (r-l) // 2

            if canShip(cap):
                r = cap - 1
            else:
                l = cap + 1

        return l


sol = Solution()
print(sol.shipWithinDays([1,2,3,4,5,6,7,8,9,10], 5))
