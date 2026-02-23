from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        if len(cost) <= 2:
            return min(cost)

        next = 0
        cur = cost[-1]

        for i in range(len(cost)-2, -1, -1):
            temp = cur
            cur = cost[i] + min(cur, next)
            next = temp

        return min(cur, next)


sol = Solution()
print(sol.minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1]))