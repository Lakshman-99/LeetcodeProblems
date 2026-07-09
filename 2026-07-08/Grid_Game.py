from itertools import accumulate
from typing import List


class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        n = len(grid[0])
        pref1 = list(accumulate(grid[0]))
        pref2 = [0] + list(accumulate(grid[1]))
        ans = float('inf')
        for i in range(n):
            ans = min(ans, max(pref1[-1] - pref1[i], pref2[i]))

        return ans


sol = Solution()
print(sol.gridGame([[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]))