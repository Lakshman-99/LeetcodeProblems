import heapq
from collections import defaultdict
from typing import List


class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        min_heap = []
        i, n = 0, len(intervals)
        res = {}

        for q in sorted(queries):
            while i < n and intervals[i][0] <= q:
                l, r = intervals[i]
                heapq.heappush(min_heap, (r - l + 1, r))
                i += 1

            while min_heap and min_heap[0][1] < q:
                heapq.heappop(min_heap)

            res[q] = min_heap[0][0] if min_heap else -1

        return [res[q] for q in queries]


sol = Solution()
print(sol.minInterval([[1,4],[2,4],[3,6],[4,4]], [2,3,4,5]))