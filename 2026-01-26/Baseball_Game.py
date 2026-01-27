from typing import List


class Solution:
    def calPoints(self, operations: List[str]) -> int:
        if not operations:
            return 0

        stack = []
        for op in operations:
            if op == "+":
                stack.append(stack[-1] + stack[-2])
            elif op == "C":
                stack.pop()
            elif op == "D":
                stack.append(stack[-1] * 2)
            else:
                stack.append(int(op))

        return sum(stack)


sol = Solution()
print(sol.calPoints(["5","2","C","D","+"]))