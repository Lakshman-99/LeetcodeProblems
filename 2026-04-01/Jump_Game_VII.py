from collections import deque
from typing import List


class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        if s[-1] == '1':
            return False

        q = deque([0])
        n = len(s)
        farthest = 0

        while q:
            i = q.popleft()
            start = max(i + minJump, farthest + 1)
            for j in range(start, min(i+maxJump+1, n)):
                if s[j] != '0':
                    continue

                if j == n-1:
                    return True

                q.append(j)

            farthest = i+maxJump

        return False


sol = Solution()
print(sol.canReach("011010", 2, 3))