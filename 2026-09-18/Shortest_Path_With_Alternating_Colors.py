from collections import deque


class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: list[list[int]], blueEdges: list[list[int]]) -> list[int]:
        RED, BLUE = 0, 1
        adj = [[[] for _ in range(n)] for _ in range(2)]

        for a, b in redEdges:
            adj[RED][a].append(b)

        for a, b in blueEdges:
            adj[BLUE][a].append(b)

        dist = [[-1] * n for _ in range(2)]
        dist[RED][0] = dist[BLUE][0] = 0

        q = deque([(0, RED), (0, BLUE)])
        while q:
            node, color = q.popleft()
            next_color = BLUE if color == RED else RED

            for nei in adj[next_color][node]:
                if dist[next_color][nei] != -1:
                    continue
                dist[next_color][nei] = dist[color][node] + 1
                q.append((nei, next_color))

        res = []
        for i in range(n):
            if dist[RED][i] == -1:
                res.append(dist[BLUE][i])
            elif dist[BLUE][i] == -1:
                res.append(dist[RED][i])
            else:
                res.append(min(dist[RED][i], dist[BLUE][i]))

        return res


sol = Solution()
print(sol.shortestAlternatingPaths(5, [[0,1],[1,2],[2,3],[3,4]], [[1,2],[2,3],[3,1]]))