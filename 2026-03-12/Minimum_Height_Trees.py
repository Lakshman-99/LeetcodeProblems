from collections import defaultdict
from typing import List

class DSU:
    def __init__(self, n):
        self.rank = [1] * n
        self.parent = [i for i in range(n)]

    def getParent(self, node):
        cur = node
        while self.parent[cur] != cur:
            self.parent[cur] = self.parent[self.parent[cur]]
            cur = self.parent[cur]

        return cur

    def union(self, u, v):
        pu = self.getParent(u)
        pv = self.getParent(v)
        if pv == pu:
            return False

        if self.rank[pv] > self.rank[pu]:
            pu, pv = pv, pu

        self.parent[pv] = pu
        self.rank[pu] += self.rank[pv]
        return True


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        def dfs(node, seen):
            if node in seen:
                return 0

            seen.add(node)
            h = 0
            for nei in adj[node]:
                h = max(h, 1 + dfs(nei, seen))

            return h


        min_h = float('inf')
        res = defaultdict(list)
        for i in range(n):
            find_max = dfs(i, set())
            min_h = min(min_h, find_max)
            res[find_max].append(i)

        return res[min_h]


sol = Solution()
print(sol.findMinHeightTrees(6, [[3,0],[3,1],[3,2],[3,4],[5,4]]))