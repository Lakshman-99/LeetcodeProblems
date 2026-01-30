from collections import deque
from typing import List


class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for c in s:
            if c != ']':
                stack.append(c)
            else:
                sub_char = deque()
                while stack and stack[-1] != '[':
                    sub_char.appendleft(stack.pop())
                stack.pop()

                repeat_count = deque()
                while stack and stack[-1].isdigit():
                    repeat_count.appendleft(stack.pop())

                stack.append(int("".join(repeat_count)) * "".join(sub_char))

        return "".join(stack)


sol = Solution()
print(sol.decodeString("3[a2[c]]"))
print(sol.decodeString("2[abc]3[cd]ef"))
