from collections import defaultdict, deque
from functools import cache
from typing import List


class Solution:
    def assignEdgeWeights(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        MOD = 10 ** 9 + 7
        n = len(edges) + 1
        adj = defaultdict(list)

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        LOG = max(1, n.bit_length())
        depth = [0] * (len(edges) + 2)
        par = [[0] * (n + 1) for _ in range(LOG)]

        def dfs(src, parent, dep):
            depth[src] = dep
            par[0][src] = parent
            for node in adj[src]:
                if node != parent:
                    dfs(node, src, dep + 1)

        dfs(1, 0, 0)

        for k in range(1, LOG):
            for u in range(1, n+1):
                par[k][u] = par[k-1][par[k-1][u]]

        def lca(u, v):
            if depth[u] < depth[v]:
                u, v = v, u

            diff = depth[u] - depth[v]
            for k in range(LOG):
                if (diff >> k) & 1:
                    u = par[k][u]

            if u == v:
                return u

            for k in range(LOG - 1, -1, -1):
                if par[k][u] != par[k][v]:
                    u = par[k][u]
                    v = par[k][v]

            return par[0][u]

        pow2 = [1] * (n + 1)
        for i in range(1, n + 1):
            pow2[i] = pow2[i - 1] * 2 % MOD

        ans = []
        for s, d in queries:
            dep = depth[s] + depth[d] - 2 * depth[lca(s, d)]
            ans.append(pow2[dep - 1] if dep > 0 else 0)

        return ans

    def assignEdgeWeights2(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        MOD = 10 ** 9 + 7
        adj = defaultdict(list)

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        @cache
        def dfs(src, dest, parent):
            if src == dest:
                return 1

            res = float('inf')
            for node in adj[src]:
                if node != parent:
                    res = min(res, 1 + dfs(node, dest, src))

            return res

        ans = []
        for s, d in queries:
            depth = dfs(s, d, 0) - 2
            choice = (1 << depth) % MOD if s != d else 0
            ans.append(choice)

        return ans


sol = Solution()
print(sol.assignEdgeWeights([[1,2],[1,3],[3,4],[3,5]], [[2,5],[1,1]]))