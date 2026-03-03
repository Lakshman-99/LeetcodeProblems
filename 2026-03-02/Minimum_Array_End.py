class Solution:
    def minEnd(self, n: int, x: int) -> int:
        res = x
        bit_x = 1
        bit_n = 1

        while bit_n < n:
            if bit_x & x == 0:
                if bit_n & (n - 1):
                    res = res | bit_x
                bit_n <<= 1
            bit_x <<= 1

        return res


sol = Solution()
print(sol.minEnd(3, 4))