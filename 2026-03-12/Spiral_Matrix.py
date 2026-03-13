from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        n, m = len(matrix), len(matrix[0])

        s, e = 0, n-1
        l, r = 0, m-1
        res = []

        while s <= e and l <= r:
            for i in range(l, r+1):
                res.append(matrix[s][i])
            s += 1

            for i in range(s, e+1):
                res.append(matrix[i][r])
            r -= 1

            if s > e or l > r:
                break

            for i in range(r, l-1, -1):
                res.append(matrix[e][i])
            e -= 1

            for i in range(e, s-1, -1):
                res.append(matrix[i][l])
            l += 1

        return res


sol = Solution()
print(sol.spiralOrder([[7],[9],[6]]))