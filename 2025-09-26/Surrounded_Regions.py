from collections import deque
from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        queue = deque()

        def bfs():
            while queue:
                row, col = queue.popleft()
                board[row][col] = 'V'
                for x, y in dirs:
                    r, c = row +x, col + y

                    if 0<=r<m and 0<=c<n and board[r][c] == 'O':
                        queue.append((r, c))

        for i in range(m):
            if board[i][0] == 'O':
                queue.append((i, 0))

            if board[i][n-1] == 'O':
                queue.append((i, n-1))

        for i in range(n):
            if board[0][i] == 'O':
                queue.append((0, i))

            if board[m-1][i] == 'O':
                queue.append((m-1, i))

        bfs()
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == 'V':
                    board[i][j] = 'O'

        print(board)
        return

sol = Solution()
sol.solve([["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]])