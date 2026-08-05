from typing import List


class Solution:
    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(n)]
        for a, b in invocations:
            adj[a].append(b)

        affected = [False] * n

        def dfs(node):
            affected[node] = True
            for nei in adj[node]:
                if not affected[nei]:
                    dfs(nei)

        dfs(k)

        visited = [False] * n

        def dfs2(node):
            if visited[node]:
                return

            visited[node] = True
            if affected[node]:
                return

            for nei in adj[node]:
                dfs2(nei)

        for i in range(n):
            if not affected[i]:
                dfs2(i)

        return [i for i in range(n) if visited[i]]


sol = Solution()
print(sol.remainingMethods(3, 2, [[1,0],[2,0]]))