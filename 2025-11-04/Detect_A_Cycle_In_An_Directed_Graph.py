class Solution:
    def isCycle(self, V, adj):
        visited = set()
        pathVisited = set()

        def checkCycle(key):
            visited.add(key)
            pathVisited.add(key)

            for i in adj[key]:
                if i not in visited and checkCycle(i):
                    return True
                elif i in visited and i in pathVisited:
                    return True

            pathVisited.remove(key)
            return False

        for i in range(V):
            if i not in visited and checkCycle(i):
                return True

        return False


sol = Solution()
print(sol.isCycle(6, [ [1], [2, 5], [3], [4], [1], []]))
print(sol.isCycle(4, [[1,2], [2], [], [0,2]]))