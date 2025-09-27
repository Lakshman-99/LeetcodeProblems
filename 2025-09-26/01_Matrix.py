from collections import deque
from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])

        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        queue = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    mat[i][j] = -1

        while queue:
            row, col = queue.popleft()
            for x, y in dirs:
                r, c = row + x, col + y

                if 0 <= r < m and 0 <= c <n and mat[r][c] == -1:
                    queue.append((r, c))
                    mat[r][c] = mat[row][col] + 1

        print(mat)
        return mat


sol = Solution()
sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]])
sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]])