class Solution:
    def canVisitAllRooms(self, rooms: list[list[int]]) -> bool:
        n = len(rooms)
        unlocked = [False] * n
        unlocked[0] = True

        def dfs(node):
            unlocked[node] = True
            for nei in rooms[node]:
                if not unlocked[nei]:
                    dfs(nei)

        for i in range(n):
            if unlocked[i]:
                dfs(i)

        return all(unlocked)


sol = Solution()
print(sol.canVisitAllRooms([[1,3],[3,0,1],[2],[0]]))