import heapq
from typing import List


class Solution:
    def maxProfit(self, inventory: List[int], orders: int) -> int:
        inventory = [-1 * num for num in inventory]
        heapq.heapify(inventory)
        MOD = 10 ** 9 + 7
        profit = 0

        while orders:
            cur = -1 * heapq.heappop(inventory)
            cu
            profit = (profit + cur) % MOD

            heapq.heappush(inventory, -1 * (cur - 1))
            orders -= 1

        return profit


sol = Solution()
print(sol.maxProfit([2,8,4,10,6], 20))