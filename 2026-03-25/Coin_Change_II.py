from functools import cache
from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount+1)
        dp[0] = 1

        for i in range(len(coins)):
            for a in range(coins[i], amount+1):
                dp[a] += dp[a-coins[i]]

        return dp[amount]

    def change2(self, amount: int, coins: List[int]) -> int:
        n = len(coins)

        @cache
        def dfs(i, cur):
            if i < 0 or cur < 0:
                return 0

            if cur == 0:
                return 1

            return dfs(i-1, cur) + dfs(i, cur - coins[i])

        return dfs(n-1, amount)


sol = Solution()
print(sol.change(5, [1,2,5]))