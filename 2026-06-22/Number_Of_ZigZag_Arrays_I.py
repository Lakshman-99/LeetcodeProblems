from functools import cache


class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 10 ** 9 + 7
        m = r - l + 1

        up = [1] * m
        down = [1] * m

        for _ in range(n-1):
            new_up = [0] * m
            new_down = [0] * m

            pref = 0
            for v in range(m):
                new_down[v] = pref
                pref = (pref + up[v]) % MOD

            suf = 0
            for v in range(m-1, -1, -1):
                new_up[v] = suf
                suf = (suf + down[v]) % MOD

            up, down = new_up, new_down

        return (sum(up) + sum(down)) % MOD

    def zigZagArrays2(self, n: int, l: int, r: int) -> int:
        MOD = 10 ** 9 + 7

        @cache
        def solve(last, dir, c):
            if c == n:
                return 1

            res = 0
            if dir == 1:
                for num in range(l, last):
                    res += solve(num, -1, c+1)
            elif dir == -1:
                for num in range(last+1, r+1):
                    res += solve(num, 1, c+1)
            else:
                for num in range(l, r+1):
                    if last < num:
                        res += solve(num, 1, c+1)
                    elif last > num:
                        res += solve(num, -1, c+1)

            return res % MOD

        return sum(solve(x, 0, 1) for x in range(l, r + 1)) % MOD

    def zigZagArrays3(self, n: int, l: int, r: int) -> int:
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