import math
from functools import cache
from typing import List


class Solution:
    def integerBreak(self, n: int) -> int:
        ans = 0
        for i in range(1, math.ceil(n / 2) + 1):
            cur_prod = 1
            if n % i == 0:
                cur_prod = i ** (n//i)
            else:
                count = 0
                tmp = n
                while tmp - i > i:
                    tmp -= i
                    count += 1

                if count == 0:
                    cur_prod = i ** (count + 1) * (tmp % i)
                else:
                    cur_prod = max(i ** count * tmp, i ** (count + 1) * (tmp % i))

            ans = max(ans, cur_prod)

        return ans


sol = Solution()
print(sol.integerBreak(8))