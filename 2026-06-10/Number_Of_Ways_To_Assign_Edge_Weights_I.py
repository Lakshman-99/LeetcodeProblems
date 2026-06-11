from collections import defaultdict, deque
from typing import List


class Solution:
    def assignEdgeWeights(self, edges: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        adj = defaultdict(list)

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        depth = -1
        q = deque([(1, 0, depth)])
        while q:
            root, parent, depth = q.popleft()
            for node in adj[root]:
                if node != parent:
                    q.append((node, root, depth + 1))

        return (1 << depth) % MOD


sol = Solution()
print(sol.assignEdgeWeights([[1,2],[1,3],[3,4],[3,5]]))