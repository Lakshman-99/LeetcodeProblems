import heapq
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        if len(points) == k:
            return points

        heap = []
        for x, y in points:
            dist = -(x ** 2 + y **2)
            heapq.heappush(heap, (dist, x, y))

            if len(heap) > k:
                heapq.heappop(heap)

        return [[x, y] for _, x, y in heap]


sol = Solution()
print(sol.kClosest([[1,3],[-2,2]], 1))