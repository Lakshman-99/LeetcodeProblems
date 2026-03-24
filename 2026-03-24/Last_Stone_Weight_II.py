from typing import List


class Solution:
    def lastStoneWeightII2(self, stones: List[int]) -> int:
        n = len(stones)
        MAX = (1 << 31) - 1
        dp = [[MAX] * (n+1) for _ in range(n+1)]


    def lastStoneWeightII(self, stones: List[int]) -> int:
        total = sum(stones)
        target = (total + 1) // 2

        def dfs(i, cur_sum):
            if i < 0 or cur_sum >= target:
                return abs(cur_sum - (total - cur_sum))

            return min(dfs(i-1, cur_sum), dfs(i-1, cur_sum + stones[i]))

        return dfs(len(stones)-1, 0)


sol = Solution()
print(sol.lastStoneWeightII([2,7,4,1,8,1]))