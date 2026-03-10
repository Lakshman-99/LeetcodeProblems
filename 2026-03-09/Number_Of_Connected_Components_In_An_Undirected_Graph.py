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
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        dsu = DSU(n)
        res = n
        for u, v in edges:
            if dsu.union(u, v):
                res -= 1

        return res


sol = Solution()
print(sol.countComponents(5, [[0,1],[1,2],[3,4]]))