from collections import deque


class Solution:
    def minReorder(self, n: int, connections: list[list[int]]) -> int:
        if n <= 1:
            return 0

        adj_dir = [set() for _ in range(n)]
        adj_undir = [[] for _ in range(n)]
        for a, b in connections:
            adj_dir[a].add(b)
            adj_undir[a].append(b)
            adj_undir[b].append(a)

        visited = set()
        edits = 0
        q = deque([0])
        while q:
            node = q.popleft()
            visited.add(node)
            for nei in adj_undir[node]:
                if nei in visited:
                    continue

                if node not in adj_dir[nei]:
                    edits += 1

                q.append(nei)

        return edits + (n - len(visited))


sol = Solution()
print(sol.minReorder(6, [[0,1],[1,3],[2,3],[4,0],[4,5]]))
