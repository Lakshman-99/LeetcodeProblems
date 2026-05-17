from typing import List


class Solution:
    def countLocalMaximums(self, matrix: list[list[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        LOGN, LOGM = max(1, n.bit_length()), max(1, m.bit_length())

        st = [[None] * LOGM for _ in range(LOGN)]
        st[0][0] = [row[:] for row in matrix]

        for j in range(1, LOGM):
            sz, half = 1 << j, 1 << (j - 1)
            prev = st[0][j - 1]
            cur = [[0] * m for _ in range(n)]
            for r in range(n):
                for c in range(m - sz + 1):
                    cur[r][c] = max(prev[r][c], prev[r][c + half])
            st[0][j] = cur

        for i in range(1, LOGN):
            sz, half = 1 << i, 1 << (i - 1)
            for j in range(LOGM):
                prev = st[i - 1][j]
                jsz = 1 << j
                cur = [[0] * m for _ in range(n)]
                for r in range(n - sz + 1):
                    a, b, cr = prev[r], prev[r + half], cur[r]
                    for c in range(m - jsz + 1):
                        cr[c] = max(a[c], b[c])
                st[i][j] = cur

        def rmq(r1, c1, r2, c2):
            if r1 > r2 or c1 > c2:
                return 0
            i = (r2 - r1 + 1).bit_length() - 1
            j = (c2 - c1 + 1).bit_length() - 1
            isz, jsz = 1 << i, 1 << j
            t = st[i][j]
            return max(t[r1][c1], t[r2 - isz + 1][c1],
                       t[r1][c2 - jsz + 1], t[r2 - isz + 1][c2 - jsz + 1])

        count = 0
        for row in range(n):
            for col in range(m):
                x = matrix[row][col]
                if x == 0:
                    continue
                rl, rh = max(0, row - x), min(n - 1, row + x)
                cl, ch = max(0, col - x), min(m - 1, col + x)

                tl = (row - x >= 0) and (col - x >= 0)
                tr = (row - x >= 0) and (col + x <= m - 1)
                bl = (row + x <= n - 1) and (col - x >= 0)
                br = (row + x <= n - 1) and (col + x <= m - 1)

                if rl == rh:
                    best = rmq(rl, cl + (tl or bl), rl, ch - (tr or br))
                else:
                    best = rmq(rl, cl + tl, rl, ch - tr)
                    if rl + 1 <= rh - 1:
                        best = max(best, rmq(rl + 1, cl, rh - 1, ch))
                    best = max(best, rmq(rh, cl + bl, rh, ch - br))

                if best <= x:
                    count += 1
        return count


sol = Solution()
print(sol.countLocalMaximums([[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,2,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]]))