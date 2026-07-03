import heapq
import math
from typing import List


class Solution:
    def findMaxPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        n = len(online)
        adj = [[] for _ in range(n)]

        for u, v, c in edges:
            adj[u].append([v, c])

        dist = [math.inf] * n
        dist[0] = 0

        q = [(0, math.inf, 0)]
        ans = -1
        while q:
            cost, mn, node = heapq.heappop(q)

            if node == n-1:
                ans = max(ans, mn)
                continue

            for nei, c in adj[node]:
                nk = cost + c
                if online[nei] and nk <= k and nk <= dist[nei]:
                    dist[nei] = nk
                    heapq.heappush(q, (nk, min(mn, c), nei))

        return ans


sol = Solution()
print(sol.findMaxPathScore([[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]], [True,True,True,False,True], 12))