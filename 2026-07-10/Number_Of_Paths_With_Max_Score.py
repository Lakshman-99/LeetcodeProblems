from collections import defaultdict, deque
from itertools import accumulate
from typing import List


class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        n = len(board)

        def solve(i, j):
            if i == j == 0:
                return 

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
print(sol.pathsWithMaxScore(["E23","2X2","12S"]))