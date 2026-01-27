
class Solution:
    def isValid(self, s: str) -> bool:
        if not s or len(s) == 1:
            return False

        map = {
            '}':'{',
            ')':'(',
            ']':'['
        }

        stack = []
        i, n = 0, len(s)
        while i < n:
            while i < n and s[i] in map and len(stack) and stack[-1] == map[s[i]]:
                stack.pop()
                i += 1

            if i == n:
                break

            stack.append(s[i])
            i += 1

        return len(stack) == 0


sol = Solution()
print(sol.isValid("(]"))