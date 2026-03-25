from functools import cache
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        buy = hold = cool = 0

        for i in range(n-1, -1, -1):
            old_buy = buy
            buy = max(buy, hold - prices[i])
            hold = max(hold, cool + prices[i])
            cool = old_buy

        return buy

    def maxProfit2(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 3 for _ in range(n+1)]

        for i in range(n-1, -1, -1):
            dp[i][0] = max(dp[i+1][0], dp[i+1][1] - prices[i])
            dp[i][1] = max(dp[i + 1][1], dp[i + 1][2] + prices[i])
            dp[i][2] = dp[i+1][0]

        return dp[0][0]

    def maxProfit3(self, prices: List[int]) -> int:
        n = len(prices)

        @cache
        def dfs(i, state):
            if i >= n:
                return 0

            if state == "buy":
                skip = dfs(i+1, "buy")
                buy = dfs(i+1, "hold") - prices[i]
                return max(skip, buy)
            elif state == "hold":
                skip = dfs(i+1, "hold")
                sell = dfs(i+1, "cool") + prices[i]
                return max(skip, sell)

            return dfs(i+1, "buy")

        return dfs(0, "buy")


sol = Solution()
print(sol.maxProfit([2,1,4]))