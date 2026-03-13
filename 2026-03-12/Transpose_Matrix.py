from typing import List


class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        n, m = len(matrix), len(matrix[0])

        transpose = []
        for i in range(m):
            cur = []
            for j in range(n):
                cur.append(matrix[j][i])

            transpose.append(cur)

        return transpose


sol = Solution()
print(sol.transpose([[1,2,3],[4,5,6]]))