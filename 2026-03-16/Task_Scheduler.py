import heapq
from collections import defaultdict, deque
from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hm = defaultdict(int)
        for task in tasks:
            hm[task] += 1

        heap = []
        for v in hm.values():
            heapq.heappush(heap, -v)

        time = 0
        q = deque()
        while heap or q:
            time += 1

            if heap:
                cnt = 1 + heapq.heappop(heap)
                if cnt:
                    q.append([cnt, time + n])

            if q and q[0][1] == time:
                heapq.heappush(heap, q.popleft()[0])

        return time


sol = Solution()
print(sol.leastInterval(["A","A","A","B","B","B"], 3))