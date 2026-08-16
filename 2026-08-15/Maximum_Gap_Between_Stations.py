import bisect
from collections import defaultdict


class Solution:
    def maximumGap(self, skill: str, station: str) -> int:
        n, m = len(skill), len(station)
        if n == 1:
            return 0

        earliest = [0] * n
        j = 0
        for i in range(n):
            while station[j] != skill[i]:
                j += 1
            earliest[i] = j
            j += 1

        latest = [0] * n
        j = m - 1
        for i in range(n - 1, -1, -1):
            while station[j] != skill[i]:
                j -= 1
            latest[i] = j
            j -= 1

        return max(latest[i] - earliest[i - 1] for i in range(1, n))





sol = Solution()
print(sol.maximumGap("cbc", "cbcdbc"))