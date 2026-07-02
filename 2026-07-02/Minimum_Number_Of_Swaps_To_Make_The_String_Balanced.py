from typing import List


class Solution:
    def minSwaps(self, s: str) -> int:
        close = opn = swaps = 0
        l, r = 0, len(s) - 1

        while l < r:
            if s[l] == ']' and s[r] == '[':
                if opn and close:
                    opn, close = opn - 1, close - 1
                else:
                    opn, close = opn + 1, close + 1
                    swaps += 1
                l, r = l + 1, r - 1
            elif s[l] == ']':
                r -= 1
                close += 1
            elif s[r] == '[':
                l += 1
                opn += 1
            else:
                l, r = l + 1, r - 1

        return swaps


sol = Solution()
print(sol.minSwaps("[]"))
