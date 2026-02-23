from typing import List


class Solution:
    def tribonacci(self, n: int) -> int:
        if n <= 2:
            return min(1, n)

        t0, t1, t2 = 0, 1, 1

        for i in range(2, n):
            temp1, temp2 = t1, t2
            t2 += t1 + t0
            t1 = temp2
            t0 = temp1

        return t2


sol = Solution()
print(sol.tribonacci(25))