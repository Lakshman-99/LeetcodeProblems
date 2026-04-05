import heapq
from typing import List


class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        DIRS = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        dist = [[float('inf')] * n for _ in range(m)]
        dist[0][0] = 0
        min_heap = [(0, 0, 0)]

        while min_heap:
            cost, i, j = heapq.heappop(min_heap)
            if i == m - 1 and j == n - 1:
                return cost
            if cost > dist[i][j]:
                continue

            for x, y in DIRS:
                a, b = i + x, j + y
                if 0 <= a < m and 0 <= b < n:
                    new_cost = max(cost, abs(heights[i][j] - heights[a][b]))
                    if new_cost < dist[a][b]:
                        dist[a][b] = new_cost
                        heapq.heappush(min_heap, (new_cost, a, b))

        return 0


sol = Solution()
print(sol.minimumEffortPath([[1,2,2],[3,8,2],[5,3,5]]))