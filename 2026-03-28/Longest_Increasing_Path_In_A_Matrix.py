from typing import List


class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dp1 = [[1] * (n + 1) for _ in range(m + 1)]
        dp2 = [[1] * (n + 1) for _ in range(m + 1)]
        longest = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if (j > 1 and matrix[i - 1][j - 1] < matrix[i - 1][j - 2]) and (i > 1 and matrix[i - 1][j - 1] < matrix[i - 2][j - 1]):
                    dp1[i][j] = max(dp1[i-1][j], dp1[i][j-1]) + 1
                elif j > 1 and matrix[i - 1][j - 1] < matrix[i - 1][j - 2]:
                    dp1[i][j] = dp1[i][j - 1] + 1
                elif i > 1 and matrix[i - 1][j - 1] < matrix[i - 2][j - 1]:
                    dp1[i][j] = dp1[i - 1][j] + 1

                if (j > 1 and matrix[i - 1][j - 1] > matrix[i - 1][j - 2]) and (i > 1 and matrix[i - 1][j - 1] > matrix[i - 2][j - 1]):
                    dp2[i][j] = max(dp2[i - 1][j], dp2[i][j - 1]) + 1
                elif j > 1 and matrix[i - 1][j - 1] > matrix[i - 1][j - 2]:
                    dp2[i][j] = dp2[i][j - 1] + 1
                elif i > 1 and matrix[i - 1][j - 1] > matrix[i - 2][j - 1]:
                    dp2[i][j] = dp2[i - 1][j] + 1

                longest = max(longest, dp1[i][j], dp2[i][j])

        return longest


sol = Solution()
print(sol.longestIncreasingPath([[9,9,4],[6,6,8],[2,1,1]]))