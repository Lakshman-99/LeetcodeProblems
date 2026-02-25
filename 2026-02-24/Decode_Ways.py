from functools import cache


class Solution:
    def numDecodings(self, s: str) -> int:
        @cache
        def dfs(i):
            if i == len(s):
                return 1

            if s[i] == '0':
                return 0

            sum = dfs(i+1)
            if i+1 < len(s) and (('1' == s[i] and '0' <= s[i+1] <= '9') or ('2' == s[i] and '0' <= s[i+1] <= '6')):
                sum += dfs(i+2)

            return sum

        next1 = next2 = 1

        for i in range(len(s)-1, -1, -1):
            sum = 0
            if s[i] != '0':
                sum += next1

            if i+1 < len(s) and (('1' == s[i] and '0' <= s[i+1] <= '9') or ('2' == s[i] and '0' <= s[i+1] <= '6')):
                sum += next2

            temp = next1
            next1 = sum
            next2 = temp

        return next1


sol = Solution()
print(sol.numDecodings("11106"))