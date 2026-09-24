from collections import defaultdict


class Solution:
    def countArrays(self, digitSum: list[int]) -> int:
        if max(digitSum) > 31:
            return 0

        sum_map = defaultdict(list)
        for i in range(5001):
            num = i
            s = 0
            while num:
                d = num % 10
                s += d
                num //= 10
            sum_map[s].append(i)

        return 0


sol = Solution()
print(sol.countArrays([25,1]))