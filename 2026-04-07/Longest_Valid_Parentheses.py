class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        longest = 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if stack:
                    longest = max(longest, i - stack[-1])
                else:
                    stack.append(i)

        return longest


sol = Solution()
print(sol.longestValidParentheses("())(()()"))