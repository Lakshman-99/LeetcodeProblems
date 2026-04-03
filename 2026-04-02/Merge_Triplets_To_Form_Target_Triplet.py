from typing import List


class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        x, y, z = target
        res = set()

        for a, b, c in triplets:
            if a > x or b > y or c > z:
                continue

            if a == x: res.add(0)
            if b == y: res.add(1)
            if c == z: res.add(2)
            if len(res) == 3:
                return True

        return False


sol = Solution()
print(sol.mergeTriplets([[2,5,3],[2,3,4],[1,2,5],[5,2,3],[2,6,9]], [5,5,5]))