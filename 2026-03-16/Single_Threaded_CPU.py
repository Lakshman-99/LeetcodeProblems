import heapq
from typing import List


class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        n = len(tasks)
        tasks = [(enq, proc, i) for i, (enq, proc) in enumerate(tasks)]
        tasks.sort()

        order = []
        heap = []
        time = i = 0

        while len(order) < n:
            while i < n and tasks[i][0] <= time:
                enq, proc, idx = tasks[i]
                heapq.heappush(heap, (proc, idx))
                i += 1

            if heap:
                proc, idx = heapq.heappop(heap)
                order.append(idx)
                time += proc
            else:
                time = tasks[i][0]

        return order


sol = Solution()
print(sol.getOrder([[1,2],[2,4],[3,2],[4,1]]))