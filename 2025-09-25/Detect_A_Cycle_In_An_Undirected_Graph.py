class Solution:
    def isCycle(self, V, adj):
        visited = set()

        def checkCycle(key, parent):
            visited.add(key)
            for value in adj[key]:
                if value not in visited:
                    if checkCycle(value, key):
                        return True
                elif value != parent:
                    return True

            return False

        for i in range(V):
            if i not in visited and checkCycle(i, -1):
                return True

        return False


sol = Solution()
sol.isCycle(6, [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]])
sol.isCycle(4, [[1, 2], [0], [0, 3], [2]])