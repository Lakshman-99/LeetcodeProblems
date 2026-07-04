import heapq
import math
from collections import deque
from typing import List


class Solution:
    def findMaxPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        n = len(online)
        adj = [[] for _ in range(n)]
        indegree = [0] * n
        maxW = 0

        for u, v, c in edges:
            adj[u].append([v, c])
            indegree[v] += 1
            maxW = max(maxW, c)

        topo = []
        q = deque([i for i in range(n) if not indegree[i]])
        while q:
            node = q.popleft()
            topo.append(node)
            for nei, c in adj[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)

        def check(exp):
            dist = [math.inf] * n
            dist[0] = 0
            for u in topo:
                if dist[u] == math.inf or not online[u]:
                    continue

                for v, c in adj[u]:
                    if c < exp or not online[v]:
                        continue

                    dist[v] = min(dist[v], dist[u] + c)

            return dist[n-1] <= k

        l, r, ans = 0, maxW, -1
        while l <= r:
            mid = (l + r) // 2
            if check(mid):
                ans = mid
                l = mid + 1
            else:
                r = mid - 1

        return ans

    def findMaxPathScore2(self, edges: List[List[int]], online: List[bool], k: int) -> int:
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