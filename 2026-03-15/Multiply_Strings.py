import heapq
from collections import defaultdict, deque
from typing import List


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        # if num2 > num1:
        #     num1, num2 = num2, num1
        #
        # def add(s1, s2):
        #     res = []
        #     i, j = len(s1)-1, len(s2)-1
        #     carry = 0
        #     while i >= 0 or j >= 0 or carry:
        #         sum = carry
        #         if i >= 0:
        #             sum += int(s1[i])
        #             i -= 1
        #
        #         if j >= 0:
        #             sum += int(s2[j])
        #             j -= 1
        #
        #         res.append(str(sum % 10))
        #         carry = sum // 10
        #
        #     res.reverse()
        #     return "".join(res)
        #
        # res = ""
        # multiplier = 1
        # for i in range(len(num2)-1, -1, -1):
        #     cur = ""
        #     carry = 0
        #     for j in range(len(num1)-1, -1, -1):
        #         prod = (multiplier * int(num2[i]) * int(num1[j])) + carry
        #         carry = prod // 10
        #         cur = str(prod % 10) + cur
        #
        #     if carry != 0:
        #         cur = str(carry) + cur
        #
        #     res = add(res, cur)
        #     multiplier *= 10
        #
        # lead_zero = 0
        # for i, num in enumerate(res):
        #     if num != '0' or i == len(res)-1:
        #         break
        #     lead_zero += 1
        #
        # return res[lead_zero:]

        if "0" in [num1, num2]:
            return "0"

        res = [0] * (len(num1) + len(num2))
        num1, num2 = num1[::-1], num2[::-1]

        for i in range(len(num1)):
            for j in range(len(num2)):
                digit = int(num1[i]) * int(num2[j])
                res[i + j] += digit
                res[i + j + 1] += res[i + j] // 10
                res[i + j] %= 10

        res, lead = res[::-1], 0
        while lead < len(res) and res[lead] == 0:
            lead += 1

        res = map(str, res[lead:])
        return "".join(res)


sol = Solution()
print(sol.multiply("123", "456"))