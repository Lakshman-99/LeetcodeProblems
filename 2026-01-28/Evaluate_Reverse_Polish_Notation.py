from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens:
            return 0

        stack = []
        ops = {
            "+": lambda x, y: x + y,
            "-": lambda x, y: x - y,
            "*": lambda x, y: x * y,
            "/": lambda x, y: int(x / y),
        }
        for token in tokens:
            if token in ops:
                num2 = stack.pop()
                num1 = stack.pop()
                stack.append(ops[token](num1, num2))
            else:
                stack.append(int(token))

        return stack[0]


sol = Solution()
print(sol.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))