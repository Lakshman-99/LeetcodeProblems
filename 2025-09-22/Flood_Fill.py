from collections import deque
from typing import List

'''
 Input: m x n
 Output: m x n
 Cases:
    

'''

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color:
            return image

        m = len(image)
        n = len(image[0])
        original_color = image[sr][sc]
        queue = deque()

        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        queue.append((sr, sc))

        while queue:
            a, b = queue.popleft()
            image[a][b] = color

            for cx, cy in dirs:
                x, y = a+cx, b+cy

                if 0<=x<m and 0<=y<n and image[x][y] == original_color:
                    queue.append((x,y))

        print(image)
        return image


sol = Solution()

sol.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2)