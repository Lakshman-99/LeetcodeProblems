from typing import List

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = set()
        provinces = 0

        def dfs(node):
            visited.add(node)
            for neighbor, connected in enumerate(isConnected[node]):
                if connected and neighbor not in visited:
                    dfs(neighbor)

        for i in range(n):
            if i not in visited:
                dfs(i)
                provinces += 1

        print(provinces)
        return provinces



sol = Solution()

sol.findCircleNum([[1,1,0],[1,1,0],[0,1,1]])
sol.findCircleNum([[1,0,0],[0,1,0],[0,0,1]])
