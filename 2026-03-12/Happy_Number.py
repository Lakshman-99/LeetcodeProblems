from collections import deque
from typing import List


class Solution:
    def isHappy(self, n: int) -> bool:
        def getSum(n):
            sum = 0
            while n:
                tmp = n % 10
                sum += tmp ** 2
                n //= 10

            return sum

        slow, fast = n, getSum(n)
        while slow != fast:
            slow = getSum(slow)
            fast = getSum(getSum(fast))

        return True if fast == 1 else False


sol = Solution()
print(sol.isHappy(3))