import heapq
from collections import defaultdict
from typing import List


class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        available = list(range(n))
        busy = []
        count = [0] * n

        for s, e in meetings:
            while busy and busy[0][0] <= s:
                _, room = heapq.heappop(busy)
                heapq.heappush(available, room)

            if available:
                room = heapq.heappop(available)
                heapq.heappush(busy, (e, room))
            else:
                end, room = heapq.heappop(busy)
                heapq.heappush(busy, (end + (e - s), room))

            count[room] += 1

        return count.index(max(count))


sol = Solution()
print(sol.mostBooked(3, [[0,10],[1,9],[2,8],[3,7],[4,6]]))