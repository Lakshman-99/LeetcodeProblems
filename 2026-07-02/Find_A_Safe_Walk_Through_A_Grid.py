import heapq
import math
from collections import deque
from typing import List


class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        m, n = len(grid), len(grid[0])
        DIRS = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        dist = [[0] * n for _ in range(m)]
        dist[0][0] = health - grid[0][0]

        q = deque([(-dist[0][0], 0, 0)])
        while q:
            d, i, j = q.popleft()

            if i == m - 1 and j == n - 1 and -d > 0:
                return True

            for x, y in DIRS:
                X, Y = i + x, j + y
                if 0 <= X < m and 0 <= Y < n and -d - grid[X][Y] > dist[X][Y]:
                    nd = -d - grid[X][Y]
                    dist[X][Y] = nd
                    q.append((-nd, X, Y))

        return False


sol = Solution()
print(sol.findSafeWalk([[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], 1))