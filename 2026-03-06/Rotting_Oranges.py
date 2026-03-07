from collections import deque
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        fresh = 0
        q = deque([])

        for row in range(m):
            for col in range(n):
                if grid[row][col] == 1: fresh += 1
                if grid[row][col] == 2:
                    q.append((row, col))

        if not fresh: return 0
        if not q: return -1

        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        minutes = -1
        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                if grid[r][c] == 1:
                    grid[r][c] = 2
                    fresh -= 1

                for i, j in dirs:
                    R, C = r + i, c + j
                    if 0 <= R <m and 0 <= C < n and grid[R][C] == 1:
                        q.append((R, C))

            minutes += 1

        return minutes if fresh == 0 else -1


sol = Solution()
print(sol.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))