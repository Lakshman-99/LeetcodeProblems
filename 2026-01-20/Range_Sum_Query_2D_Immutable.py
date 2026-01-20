from typing import List

class NumMatrix:
    def _computePrefix(self, matrix):
        dp = [row[:] for row in matrix]
        m = len(matrix)
        n = len(matrix[0])

        for i in range(1, m):
            dp[i][0] += dp[i-1][0]

        for i in range(1, n):
            dp[0][i] += dp[0][i-1]

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]

        return dp

    def __init__(self, matrix: List[List[int]]):
        self.mat = matrix
        self.dp = self._computePrefix(matrix)

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        answer = self.dp[row2][col2]

        if row1-1 >= 0:
            answer -= self.dp[row1-1][col2]

        if col1-1 >= 0:
            answer -= self.dp[row2][col1-1]

        if row1-1 >= 0 and col1-1 >= 0:
            answer += self.dp[row1-1][col1-1]

        return answer

# Your NumMatrix object will be instantiated and called as such:
# matrix = [[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(2, 1, 4, 3)

matrix = [[1,1,1],[2,2,2],[1,1,1]]
obj = NumMatrix(matrix)
param_1 = obj.sumRegion(1,1,2,2)
print(param_1)