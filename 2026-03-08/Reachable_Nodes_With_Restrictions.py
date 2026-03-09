from collections import defaultdict, deque
from typing import List


class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        if 0 in restricted:
            return 0

        outDegree = defaultdict(set)
        visited = set(restricted)

        for a, b in edges:
            outDegree[a].add(b)
            outDegree[b].add(a)

        q = deque([0])
        res = 0
        while q:
            node = q.popleft()
            res += 1
            for neighbor in outDegree[node]:
                if neighbor not in visited:
                    visited.add(node)
                    q.append(neighbor)

        return res


sol = Solution()
print(sol.reachableNodes(7, [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], [4,5]))