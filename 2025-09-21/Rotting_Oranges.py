from collections import deque
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rottenOranges = deque()
        freshOrange = 0
        minutes = 0

        for i, row in enumerate(grid):
            for j, value in enumerate(row):
                if value == 2:
                    rottenOranges.append([i, j])
                if value == 1:
                    freshOrange += 1

        if freshOrange == 0:
            return 0

        if len(rottenOranges) == 0:
            return -1

        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        while len(rottenOranges) > 0:
            curLen = len(rottenOranges)

            for i in range(curLen):
                orange = rottenOranges.popleft()
                a = orange[0]
                b = orange[1]

                for dir in directions:
                    x = a + dir[0]
                    y = b + dir[1]

                    if x<0 or y<0 or x>=len(grid) or y>=len(grid[0]):
                        continue

                    if grid[x][y] == 1:
                        grid[x][y] = 2
                        freshOrange -= 1
                        rottenOranges.append([x,y])

            minutes += 1

        print(-1 if freshOrange != 0 else minutes-1)
        return -1 if freshOrange != 0 else minutes-1


sol = Solution()

# sol.orangesRotting([[2,1,1],[1,1,0],[0,1,1]])
# sol.orangesRotting([[2,1,1],[0,1,1],[1,0,1]])
sol.orangesRotting([[0,2]])