import math
from typing import List


class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        adj = [[] for _ in range(n+1)]
        for u, v, w in roads:
            adj[u].append([v, w])
            adj[v].append([u, w])

        dist = [math.inf] * (n+1)
        dist[1] = 0

        def dfs(node):
            for nei, w in adj[node]:
                if w < dist[nei]:
                    dist[nei] = w
                    dfs(nei)

        dfs(1)
        return min(dist[2:])


sol = Solution()
print(sol.minScore(6, [[4,5,7468],[6,2,7173],[6,3,8365],[2,3,7674],[5,6,7852],[1,2,8547],[2,4,1885],[2,5,5192],[1,3,4065],[1,4,7357]]))