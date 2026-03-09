from collections import deque
from typing import List


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1

        def getChildren(lock):
            res = []
            for i in range(4):
                for j in [1, -1]:
                    digit = str((int(lock[i]) + j + 10) % 10)
                    res.append(lock[:i] + digit + lock[i+1:])

            return res

        q = deque([("0000", 0)])
        visited = set(deadends)

        while q:
            lock, turns = q.popleft()
            if lock == target:
                return turns

            for child in getChildren(lock):
                if child not in visited:
                    visited.add(child)
                    q.append((child, turns + 1))

        return -1


sol = Solution()
print(sol.openLock(["0201","0101","0102","1212","2002"], "0202"))