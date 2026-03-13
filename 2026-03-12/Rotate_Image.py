from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

            s, e = 0, n-1
            while s <= e:
                matrix[i][s], matrix[i][e] = matrix[i][e], matrix[i][s]
                s, e = s + 1, e - 1

        return


sol = Solution()
print(sol.rotate([[1,2,3],[4,5,6],[7,8,9]]))