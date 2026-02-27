from functools import cache
from typing import List


class Solution:
    def numSquares(self, n: int) -> int:
        nums = int(n ** 0.5)
        if nums * nums == n:
            return 1

        dp = [n] * (n+1)
        dp[0] = 0

        for i in range(n+1):
            for j in range(1, nums+1):
                if i < j**2:
                    break

                dp[i] = min(dp[i], 1 + dp[i-j**2])

        return dp[n]


sol = Solution()
print(sol.numSquares(11))