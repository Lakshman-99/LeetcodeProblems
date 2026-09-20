class Solution:
    def allPathsSourceTarget(self, graph: list[list[int]]) -> list[list[int]]:
        n = len(graph)
        paths = []

        def dfs(node, target, path):
            path.append(node)
            if node == target:
                paths.append(path[:])

            for nei in graph[node]:
                dfs(nei, target, path)
            path.pop()

        dfs(0, n-1, [])
        return paths



sol = Solution()
print(sol.allPathsSourceTarget([[4,3,1],[3,2,4],[3],[4],[]]))