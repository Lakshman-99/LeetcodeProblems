from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = 9

        # Brute Force o(n^3)
        # def checker(r, c):
        #     if board[r][c] == ".":
        #         return True
        #
        #     sr = int(r/3) * 3
        #     sc = int(c/3) * 3
        #     target = board[r][c]
        #
        #     # check the sub box
        #     for i in range(sr, sr+3):
        #         for j in range(sc, sc+3):
        #             if i != r and j != c and board[i][j] == target:
        #                 return False
        #
        #     # check row & column
        #     for i in range(n):
        #         if (i != c and board[r][i] == target) or (i != r and board[i][c] == target):
        #             return False
        #
        #     return True
        #
        # for row in range(9):
        #     for col in range(9):
        #         if not checker(row, col):
        #             return False

        # optimized bitmask - o(n^2)

        row = [0] * n
        col = [0] * n
        box = [0] * n

        for r in range(n):
            for c in range(n):
                val = board[r][c]
                if val == ".":
                    continue

                num = int(val) - 1
                bit = 1 << num
                box_idx = (r // 3) * 3 + (c // 3)

                if (row[r] & bit) or (col[c] & bit) or (box[box_idx] & bit):
                    return False

                row[r] |= bit
                col[c] |= bit
                box[box_idx] |= bit

        return True


sol = Solution()
print(sol.isValidSudoku([["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))

print(sol.isValidSudoku([["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))
