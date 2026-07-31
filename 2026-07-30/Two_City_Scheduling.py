from typing import List


class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        costs.sort(reverse=True, key=lambda x: abs(x[0] - x[1]))
        n = len(costs)
        ta = tb = n // 2
        ans = 0
        for a, b in costs:
            if a <= b and ta > 0:
                ta -= 1
                ans += a
            elif tb > 0:
                tb -= 1
                ans += b
            else:
                ans += a
        return ans


sol = Solution()
print(sol.twoCitySchedCost([[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]))