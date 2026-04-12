import heapq
from typing import List


class Solution:
    def sum_range(self, n1, n2):
        return (n1 * (n1 + 1)) // 2 - (n2 * (n2 + 1)) // 2

    def maxProfit(self, inventory: List[int], orders: int) -> int:
        inventory.sort(reverse=True)
        inventory.append(0)
        MOD = 10 ** 9 + 7
        profit = i = 0

        while orders:
            count = i + 1
            cur = inventory[i]
            nxt = inventory[i + 1]

            if cur > nxt:
                total = count * (cur - nxt)

                if orders >= total:
                    profit += count * self.sum_range(cur, nxt)
                    orders -= total
                else:
                    full, rem = divmod(orders, count)
                    profit += count * self.sum_range(cur, cur - full)
                    profit += rem * (cur - full)
                    orders = 0

                profit %= MOD

            i += 1

        return profit


sol = Solution()
print(sol.maxProfit([2,8,4,10,6], 20))