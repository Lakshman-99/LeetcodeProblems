from collections import defaultdict, deque
from typing import List


class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adj = [[] for _ in range(n)]
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)

        visit = set()
        def dfs(node, parent):
            if node in visit:
                return False

            visit.add(node)
            for nei in adj[node]:
                if nei == parent:
                    continue
                if not dfs(nei, node):
                    return False

            return True

        return dfs(0, -1) and len(visit) == n


sol = Solution()
print(sol.validTree(5, [[0, 1], [0, 2], [0, 3], [1, 4]]))
print(sol.validTree(5, [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]))