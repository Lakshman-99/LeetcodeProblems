from typing import List


class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        n, ans = len(grid), 0
        max_r = [0] * n
        max_c = [0] * n

        for i in range(n):
            for j in range(n):
                max_r[i] = max(max_r[i], grid[i][j])
                max_c[i] = max(max_c[i], grid[j][i])

        for i in range(n):
            for j in range(n):
                ans += min(max_r[i], max_c[j]) - grid[i][j]

        return ans


sol = Solution()
print(sol.maxIncreaseKeepingSkyline(
    [
        [59,88,44],
        [3,18,38],
        [21,26,51]
    ]
))