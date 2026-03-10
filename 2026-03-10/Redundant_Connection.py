from collections import defaultdict
from typing import List


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        parent = list(range(n+1))
        size = [1] * (n + 1)

        def get_parent(n):
            cur = n
            while cur != parent[cur]:
                parent[cur] = parent[parent[cur]]
                cur = parent[cur]
            return cur

        def union(u, v):
            pu, pv = get_parent(u), get_parent(v)

            if pu == pv: return False
            if pv > pu: pu, pv = pv, pu

            parent[pv] = pu
            size[pu] += size[pv]
            return True

        for u, v in edges:
            if not union(u, v):
                return [u, v]

        return []


sol = Solution()
print(sol.findRedundantConnection([[1,2],[2,3],[3,4],[1,4],[1,5]]))