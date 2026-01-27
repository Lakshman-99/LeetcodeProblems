from typing import List


class Solution:
    def calPoints(self, operations: List[str]) -> int:
        if not operations:
            return 0

        score = 0
        stack = []
        for op in operations:
            if op == "+":
                

sol = Solution()
print(sol.calPoints(["5","2","C","D","+"]))