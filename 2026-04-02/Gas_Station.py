from collections import deque
from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1

        n = len(gas)
        fuel = start = 0
        for i in range(n):
            fuel += (gas[i] - cost[i])
            if fuel < 0:
                fuel, start = 0, i+1

        return start


sol = Solution()
print(sol.canCompleteCircuit([2,3,4], [3,4,3]))