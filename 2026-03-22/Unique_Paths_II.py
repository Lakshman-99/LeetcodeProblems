from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1 or obstacleGrid[m-1][n-1] == 1:
            return 0

        prev = [0] * n
        prev[0] = 1

        for i in range(m):
            cur = [0] * n
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    continue

                cur[j] = cur[j - 1] + prev[j]

            prev = cur

        return prev[n - 1]


sol = Solution()
print(sol.uniquePathsWithObstacles([[0,0,0],[0,1,0],[0,0,0]]))