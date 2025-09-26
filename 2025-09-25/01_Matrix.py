from collections import deque
from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])

        result = [[0 for _ in range(n)] for _ in range(m)]
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]

        def bfs(i, j):
            queue = deque()
            queue.append((i, j))

            distance = 1
            while queue:
                curLen = len(queue)
                for i in range(curLen):
                    a, b = queue.popleft()

                    for x, y in dirs:
                        cx, cy = a+x, b+y
                        if 0<=cx<m and 0<=cy<n:
                            if mat[cx][cy] == 0:
                                return distance

                            queue.append((cx,cy))

                distance += 1

            return distance

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    continue

                v = bfs(i, j)
                result[i][j] = v

        print(result)
        return result


sol = Solution()
sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]])
sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]])