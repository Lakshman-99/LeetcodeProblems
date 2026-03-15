class Solution:
    def romanToInt(self, s: str) -> int:
        hm = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000,
        }

        res = 0
        for a, b in zip(s, s[1:]):
            if hm[a] < hm[b]:
                res -= hm[a]
            else:
                res += hm[a]

        return res + hm[s[-1]]


sol = Solution()
print(sol.romanToInt("MCMXCIV"))