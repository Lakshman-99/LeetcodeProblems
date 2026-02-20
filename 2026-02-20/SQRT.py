class Solution:
    def mySqrt(self, x: int) -> int:
        l, r = 0, max(1, x)
        count = 100
        while l < r and count > 0:
            m = (l + r) / 2.0
            if m * m == x:
                return round(m, 2)
            elif m * m > x:
                r = m
            else:
                l = m

            count -= 1
        return round(l, 2)


sol = Solution()
for i in range(26):
    print(sol.mySqrt(i))