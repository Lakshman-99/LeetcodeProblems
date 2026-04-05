import heapq
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = [[] for _ in range(n)]
        for u, v, w in times:
            adj[u-1].append((v-1, w))

        dist = [float('inf')] * n
        dist[k-1] = 0
        min_heap = [(0, k-1)]

        while min_heap:
            time, node = heapq.heappop(min_heap)
            if time > dist[node]:
                continue

            for nei, cost in adj[node]:
                new_time = time + cost
                if new_time < dist[nei]:
                    dist[nei] = new_time
                    heapq.heappush(min_heap, (new_time, nei))

        min_time = max(dist)
        return min_time if min_time != float('inf') else -1


sol = Solution()
print(sol.networkDelayTime([[2,1,1],[2,3,2],[3,4,1],[1,4,1],[4,5,1]], 5, 2))