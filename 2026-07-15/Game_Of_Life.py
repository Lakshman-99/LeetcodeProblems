from typing import List


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        DIRS = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        copy = [b[:] for b in board]
        m, n = len(board), len(board[0])

        def count(i, j):
            ones = 0
            for x, y in DIRS:
                r, c = i + x, j + y
                if 0 <= r < m and 0 <= c < n and copy[r][c]:
                    ones += 1
            return ones

        for i in range(m):
            for j in range(n):
                ones = count(i, j)
                if board[i][j] == 0:
                    if ones == 3:
                        board[i][j] = 1
                else:
                    if ones < 2 or ones > 3:
                        board[i][j] = 0

        return board

sol = Solution()
print(sol.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))