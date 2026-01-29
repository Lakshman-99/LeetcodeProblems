from collections import defaultdict
from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = [(pos, s) for pos, s in zip(position, speed)]
        pair.sort(reverse=True)

        stack = []
        for p, s in pair:
            stack.append((target - p) / s)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()

        return len(stack)


sol = Solution()
print(sol.carFleet(12, [10,8,0,5,3], [2,4,1,1,3]))
print(sol.carFleet(100, [0,2,4], [4,2,1]))