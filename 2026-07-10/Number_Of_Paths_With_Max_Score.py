from collections import defaultdict, deque
from functools import cache
from itertools import accumulate
from typing import List


class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        n = len(board)
        DIRS = [(0, -1), (-1, 0), (-1, -1)]
        MOD = 10 ** 9 + 7

        @cache
        def solve(i, j):
            if i == j == 0:
                return 0, 1

            best_score = -1
            best_path = 0
            for x, y in DIRS:
                X, Y = i + x, j + y
                if 0 <= X < n and 0 <= Y < n and board[X][Y] != 'X':
                    score, path = solve(X, Y)
                    if score == -1:
                        continue

                    if score > best_score:
                        best_score = score
                        best_path = path
                    elif score == best_score:
                        best_path += path

            if best_score == -1:
                return -1, 0

            value = 0 if board[i][j] in 'ES' else int(board[i][j])
            return best_score + value, best_path % MOD

        score, path = solve(n-1, n-1)
        if score == -1:
            score = path = 0

        return [score, path]


    def pathsWithMaxScore2(self, board: List[str]) -> List[int]:
        n = len(board)
        DIRS = [(0, -1), (-1, 0), (-1, -1)]
        MOD = 10 ** 9 + 7
        mx = 0
        freq = defaultdict(int)
        dist = [[0] * n for _ in range(n)]

        q = deque([(n - 1, n - 1, 0)])
        while q:
            i, j, path = q.popleft()

            for x, y in DIRS:
                X, Y = x + i, y + j
                if 0 <= X < n and 0 <= Y < n and board[X][Y] in "123456789":
                    nd = path + int(board[X][Y])
                    if dist[X][Y] <= nd:
                        dist[X][Y] = nd
                        q.append((X, Y, nd))
                    continue

                if X == Y == 0:
                    freq[path] += 1
                    mx = max(mx, path)

        return [mx, freq[mx]]


sol = Solution()
print(sol.pathsWithMaxScore(["E11","XXX","11S"]))