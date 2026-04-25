from typing import List


class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort(key=lambda x: x[0])

        m, n = len(robot), len(factory)
        ans = 0
        for i in range(m):
            lo, cand = float('inf'), 0
            for j in range(n):
                if factory[j][1] > 0 and lo >= abs(robot[i] - factory[j][0]):
                    lo = abs(robot[i] - factory[j][0])
                    cand = j

            factory[cand][1] -= 1
            ans += lo

        return ans


sol = Solution()
print(sol.minimumTotalDistance([9,11,99,101], [[10,1],[7,1],[14,1],[100,1],[96,1],[103,1]]))