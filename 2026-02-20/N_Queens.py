from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [['.'] * n for _ in range(n)]
        col = 0
        pos_diag = 0
        neg_diag = 0

        def dfs(r):
            nonlocal col, pos_diag, neg_diag
            if r == n:
                cur_board = ["".join(row) for row in board]
                res.append(cur_board)
                return

            for c in range(n):
                if (col & (1 << c)) or (pos_diag & (1 << (r + c))) or (neg_diag & (1 << (r - c + n))):
                    continue

                col ^= (1 << c)
                pos_diag ^= (1 << (r + c))
                neg_diag ^= (1 << (r - c + n))
                board[r][c] = 'Q'

                dfs(r + 1)

                col ^= (1 << c)
                pos_diag ^= (1 << (r + c))
                neg_diag ^= (1 << (r - c + n))
                board[r][c] = '.'

        dfs(0)
        return res


sol = Solution()
print(sol.solveNQueens(6))
