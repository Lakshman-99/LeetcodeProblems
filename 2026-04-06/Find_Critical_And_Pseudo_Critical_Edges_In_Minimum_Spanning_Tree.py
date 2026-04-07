from typing import List

class DSU:
    def __init__(self, n):
        self.n = n
        self.parent = list(range(n + 1))
        self.rank = [1] * (n + 1)

    def find(self, v1):
        while v1 != self.parent[v1]:
            self.parent[v1] = self.parent[self.parent[v1]]
            v1 = self.parent[v1]
        return v1

    def union(self, v1, v2):
        p1, p2 = self.find(v1), self.find(v2)
        if p1 == p2:
            return False

        self.n -= 1
        if self.rank[p1] < self.rank[p2]:
            p1, p2 = p2, p1

        self.parent[p2] = p1
        self.rank[p1] += self.rank[p2]

        return True

    def is_connected(self):
        return self.n == 1

class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        for i, e in enumerate(edges):
            e.append(i)

        edges.sort(key=lambda x: x[2])

        def get_MST(idx, include):
            dsu = DSU(n)
            mst = 0
            if include:
                mst += edges[idx][2]
                dsu.union(edges[idx][0], edges[idx][1])

            for i, e in enumerate(edges):
                if i == idx:
                    continue

                if dsu.union(e[0], e[1]):
                    mst += e[2]

            return mst if dsu.is_connected() else float('inf')

        mst_wei = get_MST(-1, False)
        critical, pseudo = [], []
        for i, e in enumerate(edges):
            if mst_wei < get_MST(i, False):
                critical.append(e[3])
            elif mst_wei == get_MST(i, True):
                pseudo.append(e[3])

        return [critical, pseudo]


sol = Solution()
print(sol.findCriticalAndPseudoCriticalEdges(5, [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]))