class Solution:
    def shortestPalindrome(self, s: str) -> str:
        pref = suff = index = 0
        base, power = 31, 1
        MOD = 10 ** 9 + 7

        for i, c in enumerate(s):
            char = ord(c) - ord('a') + 1

            pref = (pref * base + char) % MOD
            suff = (suff + char * power) % MOD
            power = (power * base) % MOD

            if pref == suff:
                index = i

        return s[index+1:][::-1] + s


sol = Solution()
print(sol.shortestPalindrome("aacecaaa"))