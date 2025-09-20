class Solution:
    def findNumberOfComponent(self, V, edges):
        visited = [False] * V
        connected = 0

        def dfs(vertex):
            visited[vertex] = True
            if vertex < len(edges) and not visited[edges[vertex][1]]:
                dfs(edges[vertex][1])

        for i in range(V):
            if not visited[i]:
                dfs(i)
                connected += 1

        print(connected)
        return connected


sol = Solution()

sol.findNumberOfComponent(4, [[0,1],[1,2]])
sol.findNumberOfComponent(7, [[0, 1], [1, 2], [2, 3], [4, 5]])