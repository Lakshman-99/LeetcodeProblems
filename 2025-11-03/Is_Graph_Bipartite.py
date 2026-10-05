from typing import List

class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        visited = [-1] * n

        def dfs(idx, color):
            visited[idx] = color
            for nei in graph[idx]:
                if visited[nei] == color:
                    return False
                if visited[nei] == -1:
                    if not dfs(nei, 1 - color):
                        return False

            return True

        for i in range(n):
            if visited[i] == -1:
                if not dfs(i, 0):
                    return False

        return True


sol = Solution()

sol.isBipartite([[1,2,3],[0,2],[0,1,3],[0,2]])
sol.isBipartite([[1,3],[0,2],[1,3],[0,2]])