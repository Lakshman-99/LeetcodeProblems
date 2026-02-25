from functools import cache
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        @cache
        def dfs(cur_amount):
            if cur_amount == 0:
                return 0
            ans = float('inf')
            for coin in coins:
                if cur_amount - coin >= 0:
                    ans = min(ans, dfs(cur_amount - coin) + 1)
            return ans

        ans = dfs(amount)
        if ans == float('inf'):
            return -1

        return ans


sol = Solution()
print(sol.coinChange([195,265,404,396], 3239))