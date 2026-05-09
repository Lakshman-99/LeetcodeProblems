import heapq
from collections import deque
from typing import List


class Solution:
    def minimumThreshold(self, n: int, edges: List[List[int]], source: int, target: int, k: int) -> int:
        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        INF = float('inf')
        dist = [[INF] * (k + 1) for _ in range(n)]
        dist[source][0] = 0
        q = [(0, 0, source)]

        while q:
            light, heavy, node = heapq.heappop(q)
            if node == target:
                return light

            if light > dist[node][heavy]:
                continue

            for nei, cost in adj[node]:
                nm = max(light, cost)
                if nm < dist[nei][heavy]:
                    dist[nei][heavy] = nm
                    heapq.heappush(q, (nm, heavy, nei))

                if heavy < k and light < dist[nei][heavy + 1]:
                    dist[nei][heavy + 1] = light
                    heapq.heappush(q, (light, heavy + 1, nei))

        return -1


sol = Solution()
print(sol.minimumThreshold(4, [[0,1,41],[1,3,60],[1,2,58],[0,2,3]], 2, 1, 0))