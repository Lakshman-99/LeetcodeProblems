import heapq
from typing import List


class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        def solve():
            if grid[0][0] == grid[-1][-1] == -1:
                return 0

            m, n = len(grid), len(grid[0])
            q = [(0, 0, 0, [])]
            mx, mx_path = 0, []
            while q:
                ch, i, j, path = heapq.heappop(q)
                ch = -ch + grid[i][j]
                path.append((i, j))
                if i == m - 1 and j == n - 1 and mx < ch:
                    mx = ch
                    mx_path = path
                    continue

                if i + 1 < m and grid[i + 1][j] != -1:
                    heapq.heappush(q, (-ch, i + 1, j, path[:]))

                if j + 1 < n and grid[i][j + 1] != -1:
                    heapq.heappush(q, (-ch, i, j + 1, path[:]))

            for x, y in mx_path:
                grid[x][y] = 0

            return mx

        a = solve()
        b = solve()

        return a + b

sol = Solution()
print(sol.cherryPickup([[0,1,1,0],[1,0,0,0],[-1,1,-1,0],[-1,1,1,0]]))