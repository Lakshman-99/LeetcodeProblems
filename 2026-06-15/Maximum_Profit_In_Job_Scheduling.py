from bisect import bisect_left
from functools import cache
from typing import List


class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        jobs = sorted(zip(startTime, endTime, profit))
        starts = [s for s, e, p in jobs]
        n = len(jobs)

        dp = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            s, e, p = jobs[i]

            j = bisect_left(starts, e)
            take = p + dp[j]
            not_take = dp[i + 1]
            dp[i] = max(dp[i], take, not_take)

        return dp[0]

    def jobScheduling2(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        jobs = sorted(zip(startTime, endTime, profit))
        starts = [s for s, e, p in jobs]
        n = len(jobs)

        @cache
        def solve(i):
            if i == n:
                return 0

            j = bisect_left(starts, jobs[i][1])
            take = jobs[i][2] + solve(j)
            not_take = solve(i+1)

            return max(take, not_take)

        return solve(0)


sol = Solution()
print(sol.jobScheduling([1,2,3,4,6], [3,5,10,6,9], [20,20,100,70,60]))