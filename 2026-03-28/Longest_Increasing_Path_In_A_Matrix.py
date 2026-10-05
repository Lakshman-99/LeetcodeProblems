from functools import cache
from typing import List


class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        DIRS = [(0,1),(1,0),(0,-1),(-1,0)]

        @cache
        def dfs(i, j):
            res = 1
            for x, y in DIRS:
                A, B = i + x, j + y
                if 0 <= A < m and 0 <= B < n and matrix[i][j] < matrix[A][B]:
                    res = max(res, dfs(A, B) + 1)

            return res

        ans = 0
        for i in range(m):
            for j in range(n):
                ans = max(ans, dfs(i, j))

        return ans


sol = Solution()
print(sol.longestIncreasingPath([[7,8,9],[9,7,6],[7,2,3]]))
