from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0

        min_stock = prices[0]
        max_profit = 0
        for price in prices:
            min_stock = min(min_stock, price)
            max_profit = max(max_profit, price - min_stock)

        return max_profit


sol = Solution()
print(sol.maxProfit([7,6,4,3,1]))