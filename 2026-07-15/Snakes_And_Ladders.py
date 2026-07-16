from collections import deque
from typing import List


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        end = n ** 2
        seen = {1}
        q = deque([(-1, 0)])

        while q:
            pos, step = q.popleft()
            pos = -pos

            for nxt in range(pos+1, min(pos+6, end)+1):
                num = nxt - 1
                last = num // n
                i = n - last - 1
                j = num % n if last % 2 == 0 else n - num % n - 1
                to_push = nxt if board[i][j] == -1 else board[i][j]
                ns = step + 1

                if to_push == end:
                    return ns

                if to_push not in seen:
                    seen.add(to_push)
                    q.append((-to_push, ns))

        return -1


sol = Solution()
print(sol.snakesAndLadders([[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]))