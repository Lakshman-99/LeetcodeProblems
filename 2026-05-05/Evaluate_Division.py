from collections import defaultdict
from typing import List

class UnionFind:
    def __init__(self):
        self.parent = {}
        self.weight = {}

    def add(self, x):
        if x not in self.parent:
            self.parent[x] = x
            self.weight[x] = 1.0

    def find(self, x):
        if x != self.parent[x]:
            orig_parent = self.parent[x]
            self.parent[x] = self.find(self.parent[x])
            self.weight[x] *= self.weight[orig_parent]
        return self.parent[x]

    def union(self, x, y, value):
        self.add(x)
        self.add(y)
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x != root_y:
            self.parent[root_x] = root_y
            self.weight[root_x] = value * self.weight[y] / self.weight[x]

    def get_ratio(self, x, y):
        if x not in self.parent or y not in self.parent or self.find(x) != self.find(y):
            return -1.0
        return self.weight[x] / self.weight[y]

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        uf = UnionFind()

        for (a, b), value in zip(equations, values):
            uf.union(a, b, value)

        return [uf.get_ratio(a, b) for a, b in queries]

    def calcEquation2(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        adj = defaultdict(list)
        for i in range(len(equations)):
            s, d = equations[i]
            cost = values[i]
            adj[s].append([d, cost])
            adj[d].append([s, 1 / cost])

        def dfs(src, dest, seen, total_cost):
            if src not in seen and src in adj:
                if src == dest:
                    return total_cost

                seen.add(src)
                for nei, cost in adj[src]:
                    search = dfs(nei, dest, seen, total_cost * cost)
                    if search != -1.0:
                        return search

            return -1.0

        res = []
        for s, d in queries:
            res.append(dfs(s, d, set(), 1))

        return res


sol = Solution()
print(sol.calcEquation([["a","b"],["b","c"]], [2.0,3.0], [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]))