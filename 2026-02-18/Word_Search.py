from collections import Counter
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not word:
            return True

        board_count = Counter(c for row in board for c in row)
        word_count = Counter(word)

        for c in word_count:
            if word_count[c] > board_count[c]:
                return False

        if board_count[word[0]] > board_count[word[-1]]:
            word = word[::-1]

        def dfs(i, j, idx):
            if i<0 or j<0 or i>=len(board) or j>=len(board[0]) or board[i][j] != word[idx]:
                return False

            if idx == len(word)-1:
                return True

            chr = board[i][j]
            board[i][j] = '0'
            btm = dfs(i+1, j, idx+1)
            top = dfs(i-1, j, idx+1)
            right = dfs(i, j+1, idx+1)
            left = dfs(i, j-1, idx+1)
            board[i][j] = chr

            return btm or top or right or left

        for i, row in enumerate(board):
            for j, ch in enumerate(row):
                if ch == word[0] and dfs(i, j, 0):
                    return True

        return False


sol = Solution()
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))