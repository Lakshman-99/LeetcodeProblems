from typing import List


class Solution:
    def minGenerations(self, points: List[List[int]], target: List[int]) -> int:
        points = set((x, y, z) for x, y, z in points)
        target = tuple(target)
        k = 0
        prev = -1

        while True:
            if target in points:
                break

            lis = list(points)
            for i in range(len(lis)):
                x1,y1,z1 = lis[i]
                for j in range(i+1, len(lis)):
                    x2,y2,z2 = lis[j]
                    points.add(((x1+x2)//2, (y1+y2)//2, (z1+z2)//2))

            if len(points) == 1 or prev == len(points):
                k = -1
                break

            prev = len(points)
            k += 1

        return k


sol = Solution()
print(sol.minGenerations([[2,0,5],[0,5,5]], [0,2,4]))