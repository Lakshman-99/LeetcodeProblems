from collections import defaultdict, deque
from typing import List


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]

        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        edge_count = [0] * n
        q = deque([])
        for src, neighbors in enumerate(adj):
            edge_count[src] = len(neighbors)
            if len(neighbors) == 1:
                q.append(src)

        while q:
            if n <= 2:
                break

            for _ in range(len(q)):
                node = q.popleft()
                n -= 1
                for nei in adj[node]:
                    edge_count[nei] -= 1
                    if edge_count[nei] == 1:
                        q.append(nei)

        return list(q)


sol = Solution()
print(sol.findMinHeightTrees(1, []))