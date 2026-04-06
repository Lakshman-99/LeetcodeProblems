import heapq
from typing import List


class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        DIRS = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        dist = [[float('inf')] * n for _ in range(n)]
        dist[0][0] = grid[0][0]
        min_heap = [(grid[0][0], 0, 0)]

        while min_heap:
            time, i, j = heapq.heappop(min_heap)
            if i == n-1 and j == n-1:
                return time

            for x, y in DIRS:
                a, b = i+x, j+y
                if 0 <= a < n and 0 <= b < n:
                    new_time = max(time, grid[a][b])
                    if new_time < dist[a][b]:
                        dist[a][b] = new_time
                        heapq.heappush(min_heap, (new_time, a, b))

        return 0


sol = Solution()
print(sol.swimInWater([[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]))