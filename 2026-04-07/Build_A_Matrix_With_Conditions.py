from collections import deque, defaultdict
from typing import List


class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        def get_topo_sort(condition):
            graph = defaultdict(list)
            in_degree = [0] * (k + 1)
            for u, v in condition:
                graph[u].append(v)
                in_degree[v] += 1
            queue = deque(i for i in range(1, k + 1) if in_degree[i] == 0)
            order = []
            while queue:
                node = queue.popleft()
                order.append(node)
                for nei in graph[node]:
                    in_degree[nei] -= 1
                    if in_degree[nei] == 0:
                        queue.append(nei)
            return order if len(order) == k else []

        row_order = get_topo_sort(rowConditions)
        col_order = get_topo_sort(colConditions)
        if not row_order or not col_order:
            return []

        matrix = [[0] * k for _ in range(k)]
        row_idx = {val: i for i, val in enumerate(row_order)}
        col_idx = {val: i for i, val in enumerate(col_order)}

        for val in range(1, k + 1):
            matrix[row_idx[val]][col_idx[val]] = val

        return matrix


sol = Solution()
print(sol.buildMatrix(3, [[1,2],[3,2]], [[2,1],[3,2]]))