from collections import Counter


class Solution:
    def minFlips(self, s: str) -> int:
        count = Counter(s)
        if len(count) > 1:
            ones, zeros = count['1'], count['0']
            if ones > 1:
                if s[0] == s[-1] == '1':
                    if ones == 2:
                        return 0
                    elif zeros < ones-2:
                        return zeros
                    return ones - 2

                if zeros < ones:
                    return zeros
                return ones - 1
        return 0

sol = Solution()
print(sol.minFlips("1011001"))