from functools import cache


class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 10 ** 9 + 7

        @cache
        def solve(last, dir, c):
            if c == n:
                return 1

            res = 0
            if dir == 1:
                for num in range(last-1, l-1, -1):
                    res += solve(num, -1, c+1)
            elif dir == -1:
                for num in range(last+1, r+1):
                    res += solve(num, 1, c+1)

            return res



    def zigZagArrays2(self, n: int, l: int, r: int) -> int:
        MOD = 10 ** 9 + 7

        @cache
        def solve(p2, p1, c):
            if c == n:
                return 1

            res = 0
            for num in range(l, r + 1):
                if num != p1 and (p2 == 0 or not (p2 < p1 < num or p2 > p1 > num)):
                    res += solve(p1, num, c + 1)

            return res % MOD

        return solve(0, 0, 0)


sol = Solution()
print(sol.zigZagArrays(14,71,166))