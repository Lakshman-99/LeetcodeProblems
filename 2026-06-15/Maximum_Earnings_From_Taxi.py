from bisect import bisect_left
from functools import cache
from typing import List


class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        n = len(rides)
        rides.sort()
        starts = [s for s, e, p in rides]
        dp = [0] * (n+1)

        for i in range(n-1, -1, -1):
            s, e, p = rides[i]

            j = bisect_left(starts, e)
            take = e - s + p + dp[j]
            not_take = dp[i+1]
            dp[i] = max(dp[i], take, not_take)

        return dp[0]


sol = Solution()
print(sol.maxTaxiEarnings(20, [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]))