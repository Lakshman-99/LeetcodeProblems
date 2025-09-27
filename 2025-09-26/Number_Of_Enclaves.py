from collections import deque
from typing import List

class Solution:
    def numEnclaves(self, board: List[List[int]]) -> int:
        m, n = len(board), len(board[0])
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        queue = deque()

        def bfs():
            while queue:
                row, col = queue.popleft()
                for x, y in dirs:
                    r, c = row + x, col + y
                    if 0 <= r < m and 0 <= c < n and board[r][c] == 1:
                        board[r][c] = -1
                        queue.append((r, c))

        for i in range(m):
            if board[i][0] == 1:
                board[i][0] = -1
                queue.append((i, 0))
            if board[i][n-1] == 1:
                board[i][n-1] = -1
                queue.append((i, n-1))

        for j in range(n):
            if board[0][j] == 1:
                board[0][j] = -1
                queue.append((0, j))
            if board[m-1][j] == 1:
                board[m-1][j] = -1
                queue.append((m-1, j))

        bfs()

        count = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == 1:
                    count += 1

        return count


sol = Solution()
sol.numEnclaves([[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]])