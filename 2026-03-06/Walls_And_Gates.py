from collections import deque
from typing import List


class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]):
        m, n = len(grid), len(grid[0])
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        INF = 2147483647
        q = deque([])
        seen = set()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    seen.add((i, j))
                    q.append((i, j))

        dist = 0
        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                grid[r][c] = dist

                for x, y in dirs:
                    rx, cy = x+r, y+c
                    if 0 <= rx < m and 0 <= cy < n and grid[rx][cy] == INF:
                        seen.add((rx, cy))
                        q.append((rx, cy))

            dist += 1

        return grid


sol = Solution()
print(sol.islandsAndTreasure([
  [2147483647,-1,0,2147483647],
  [2147483647,2147483647,2147483647,-1],
  [2147483647,-1,2147483647,-1],
  [0,-1,2147483647,2147483647]
]))