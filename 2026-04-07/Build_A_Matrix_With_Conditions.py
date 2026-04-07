from collections import deque
from typing import List


class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        def get_topo_sort(condition):
            adj = [[] for _ in range(k)]
            in_degree = [0] * k

            for v1, v2 in condition:
                adj[v2-1].append(v1-1)
                in_degree[v1-1] += 1

            q = deque([i for i in range(k) if in_degree[i] == 0])
            res = []

            while q:
                node = q.popleft()
                res.append(node + 1)
                for nei in adj[node]:
                    in_degree[nei] -= 1
                    if in_degree[nei] == 0:
                        q.append(nei)

            res.reverse()
            return res

        row_order = get_topo_sort(rowConditions)
        col_order = get_topo_sort(colConditions)
        if not row_order or not col_order:
            return []

        matrix = [[0] * k for _ in range(k)]

        for i in range(k):
            for j in range(k):
                if row_order[i] == col_order[j]:
                    matrix[i][j] = row_order[i]

        return matrix


sol = Solution()
print(sol.buildMatrix(3, [[1,2],[3,2]], [[2,1],[3,2]]))