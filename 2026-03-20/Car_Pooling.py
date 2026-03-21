import heapq
from collections import deque
from typing import List


class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key=lambda x: x[1])
        min_heap = []
        cur_cap = 0

        for cap, src, dest in trips:
            while min_heap and src >= min_heap[0][0]:
                cur_cap -= min_heap[0][1]
                heapq.heappop(min_heap)

            if cur_cap + cap > capacity:
                return False

            cur_cap += cap
            heapq.heappush(min_heap, (dest, cap))

        return True


sol = Solution()
print(sol.carPooling([[9,3,4],[9,1,7],[4,2,4],[7,4,5]], 23))