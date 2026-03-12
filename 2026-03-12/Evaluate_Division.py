from collections import defaultdict
from typing import List


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
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