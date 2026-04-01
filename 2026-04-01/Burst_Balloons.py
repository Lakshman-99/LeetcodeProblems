from functools import cache
from typing import List


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        nums = [1] + nums + [1]
        dp = [[0] * (n + 2) for _ in range(n+2)]

        for l in range(n, 0, -1):
            for r in range(l, n + 1):
                for i in range(l, r + 1):
                    coins = nums[l-1] * nums[i] * nums[r+1]
                    coins += dp[l][i-1] + dp[i+1][r]
                    dp[l][r] = max(dp[l][r], coins)

        return dp[1][n]

    def maxCoins2(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]

        @cache
        def dfs(l, r):
            if l > r:
                return 0

            max_coins = 0
            for i in range(l, r + 1):
                coins = nums[l - 1] * nums[i] * nums[r + 1]
                coins += dfs(l, i-1) + dfs(i+1, r)
                max_coins = max(max_coins, coins)

            return max_coins

        return dfs(1, len(nums)-2)

    def maxCoins3(self, nums: List[int]) -> int:
        @cache
        def dfs(loons):
            if not loons:
                return 0

            n = len(loons)
            max_coins = 0
            for i in range(n):
                left = 1 if i == 0 else loons[i-1]
                right = 1 if i == n-1 else loons[i+1]
                coins = left * loons[i] * right

                new_loons = loons[:i] + loons[i+1:]

                max_coins = max(max_coins, coins + dfs(tuple(new_loons)))

            return max_coins

        return dfs(tuple(nums))


sol = Solution()
print(sol.maxCoins([3,1,5,8]))