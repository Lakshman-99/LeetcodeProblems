class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0:
            return 0

        if n == 0:
            return 1

        res = 1
        pw = abs(n)
        while pw:
            if pw & 1:
                res *= x

            x *= x
            pw >>= 1

        return res if n >= 0 else 1 / res


sol = Solution()
print(sol.myPow(2.0, -200000000))