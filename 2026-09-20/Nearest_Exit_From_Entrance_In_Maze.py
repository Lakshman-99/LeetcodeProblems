from collections import deque


class Solution:
    def nearestExit(self, maze: list[list[str]], entrance: list[int]) -> int:
        m, n = len(maze), len(maze[0])
        DIRS = ((1, 0), (0, 1), (-1, 0), (0, -1))

        i, j = entrance
        maze[i][j] = '+'
        q = deque([(i, j, 0)])
        while q:
            x, y, steps = q.popleft()

            for dx, dy in DIRS:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and maze[nx][ny] == '.':
                    if nx == 0 or nx == m-1 or ny == 0 or ny == n-1:
                        return steps + 1

                    maze[nx][ny] = '+'
                    q.append((nx, ny, steps + 1))

        return -1


sol = Solution()
print(sol.nearestExit([["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], [1,2]))