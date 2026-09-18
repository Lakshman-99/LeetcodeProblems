class Solution:
    def canVisitAllRooms(self, rooms: list[list[int]]) -> bool:
        n = len(rooms)
        visited = [False] * n

        def dfs(node):
            if visited[node]:
                return True

            

        return all(visited)