import heapq
import math
from collections import deque
from typing import List


class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        if grid[0][0] or grid[-1][-1]:
            return 0

        m, n = len(grid), len(grid[0])
        DIRS = [(1, 0),(-1,0),(0,1),(0,-1)]

        q = deque([(i, j) for i in range(m) for j in range(n) if grid[i][j]])
        while q:
            x, y = q.popleft()
            v = grid[x][y]

            for dx, dy in DIRS:
                X, Y = x + dx, y + dy
                if 0 <= X < m and 0 <= Y < n and not grid[X][Y]:
                    grid[X][Y] = v + 1
                    q.append((X, Y))

        q = [(-grid[0][0], 0, 0)]
        while q:
            s, i, j = heapq.heappop(q)
            grid[i][j] *= -1
            if i == m-1 and j == n-1:
                return -s - 1

            if j + 1 < n and grid[i][j+1] > 0:
                heapq.heappush(q, (max(s, -grid[i][j+1]), i, j+1))

            if i + 1 < m and grid[i+1][j] > 0:
                heapq.heappush(q, (max(s, -grid[i+1][j]), i+1, j))

        return 0


sol = Solution()
print(sol.maximumSafenessFactor([[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]))