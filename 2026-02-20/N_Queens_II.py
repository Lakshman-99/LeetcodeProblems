from typing import List


class Solution:
    def totalNQueens(self, n: int) -> int:
        res = 0
        col = 0
        pos_diag = 0
        neg_diag = 0

        def dfs(r):
            nonlocal res, col, pos_diag, neg_diag
            if r == n:
                res += 1
                return

            for c in range(n):
                if (col & (1 << c)) or (pos_diag & (1 << (r + c))) or (neg_diag & (1 << (r - c + n))):
                    continue

                col ^= (1 << c)
                pos_diag ^= (1 << (r + c))
                neg_diag ^= (1 << (r - c + n))

                dfs(r + 1)

                col ^= (1 << c)
                pos_diag ^= (1 << (r + c))
                neg_diag ^= (1 << (r - c + n))

        dfs(0)
        return res


sol = Solution()
print(sol.totalNQueens(6))
