from collections import deque


class Solution:
    def shortestPathBinaryMatrix(self, grid: list[list[int]]) -> int:
        if grid[0][0] == 1 or grid[-1][-1] == 1:
            return -1
        DIRS = (1, 0, -1)

        n = len(grid)
        grid[0][0] = 1
        q = deque([(0, 0, 1)])
        while q:
            r, c, step = q.popleft()
            for dr in DIRS:
                for dc in DIRS:
                    if dr == dc == 0:
                        continue
                    nr, nc = dr + r, dc + c
                    if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] == 0:
                        if nr == n - 1 and nc == n - 1:
                            return step + 1
                        grid[nr][nc] = 1
                        q.append((nr, nc, step + 1))

        return -1


sol = Solution()
print(sol.shortestPathBinaryMatrix([[0,0,0],[1,1,0],[1,1,0]]))