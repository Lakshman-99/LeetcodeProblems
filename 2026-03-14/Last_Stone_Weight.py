import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for stone in stones:
            heapq.heappush(heap, -1 * stone)

        while len(heap) > 1:
            s1, s2 = -1*heapq.heappop(heap), -1*heapq.heappop(heap)
            if s1 != s2:
                heapq.heappush(heap, s2 - s1)

        return -1*heap[0] if len(heap) > 0 else 0


sol = Solution()
print(sol.lastStoneWeight([2,7,4,1,8,1]))