import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        min = 1
        maxi = max(piles)
        answer = maxi

        while min <= maxi:
            k = math.ceil((maxi + min) / 2)

            hrs = 0
            for pile in piles:
                hrs += math.ceil(pile / k)

            if hrs <= h:
                answer = k
                maxi = k - 1
            else:
                min = k + 1

        return answer


sol = Solution()

sol.minEatingSpeed([1,1,1,999999999], 10) # 142857143