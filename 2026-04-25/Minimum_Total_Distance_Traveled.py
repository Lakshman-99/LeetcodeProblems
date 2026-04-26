from functools import cache
from typing import List


class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort(key=lambda x: x[0])

        factory_pos = []
        for pos, count in factory:
            factory_pos.extend([pos] * count)

        m, n = len(robot), len(factory_pos)

        @cache
        def solve(i, j):
            if i >= m:
                return 0

            if j >= n:
                return float('inf')

            repair = abs(robot[i] - factory_pos[j]) + solve(i+1, j+1)
            not_repair = solve(i, j+1)

            return min(repair, not_repair)

        ans = solve(0, 0)
        solve.cache_clear()
        return ans


sol = Solution()
print(sol.minimumTotalDistance([9,11,99,101], [[10  ,1],[7,1],[14,1],[100,1],[96,1],[103,1]]))