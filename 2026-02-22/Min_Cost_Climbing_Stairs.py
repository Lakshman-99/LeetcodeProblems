from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        if len(cost) <= 2:
            return min(cost)

        s1 = cost[0]
        s2 = cost[1]

        for i in range(2, len(cost)):
            temp = s2
            s2 



sol = Solution()
print(sol.minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1]))