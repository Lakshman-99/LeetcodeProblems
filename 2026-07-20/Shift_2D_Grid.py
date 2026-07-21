from typing import List


class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        t = m * n
        k %= t
        pos = 0
        res = [[0] * n for _ in range(m)]

        for ind in range(k, k + t):
            ind %= t
            i = ind // n
            j = ind % n

            I = pos // n
            J = pos % n

            res[i][j] = grid[I][J]
            pos += 1

        return res


sol = Solution()
print(sol.shiftGrid([[1],[2],[3],[4],[7],[6],[5]], 23))