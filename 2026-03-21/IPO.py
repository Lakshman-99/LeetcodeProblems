import heapq
from typing import List


class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        n = len(profits)
        pos = list(range(n))
        pos.sort(key=lambda x: capital[x])

        max_heap = []
        i = 0
        for _ in range(k):
            while i < n and capital[pos[i]] <= w:
                heapq.heappush(max_heap, -profits[pos[i]])
                i += 1

            if not max_heap:
                break

            w += -heapq.heappop(max_heap)

        return w


sol = Solution()
print(sol.findMaximizedCapital(2, 0, [1,2,3], [0,1,1]))