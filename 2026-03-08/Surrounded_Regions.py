from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m, n = len(board), len(board[0])

        def dfs(r, c):
            if 0 <= r < m and 0 <= c < n and board[r][c] == 'O':
                board[r][c] = 'Z'
                dfs(r + 1, c)
                dfs(r, c + 1)
                dfs(r - 1, c)
                dfs(r, c - 1)

        for i in range(n):
            if board[0][i] == 'O': dfs(0, i)
            if board[m-1][i] == 'O': dfs(m-1, i)

        for i in range(m):
            if board[i][0] == 'O': dfs(i, 0)
            if board[i][n-1] == 'O': dfs(i, n-1)

        for r in range(m):
            for c in range(n):
                if board[r][c] == 'O': board[r][c] = 'X'
                if board[r][c] == 'Z': board[r][c] = 'O'

        return


sol = Solution()
print(sol.solve([["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]))