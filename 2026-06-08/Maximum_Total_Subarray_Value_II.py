import heapq
from typing import List


class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        n = len(nums)
        LOG = max(1, n.bit_length())

        mx = [nums[:]] + [[0] * n for _ in range(LOG - 1)]
        mn = [nums[:]] + [[0] * n for _ in range(LOG - 1)]
        for j in range(1, LOG):
            half = 1 << (j - 1)
            for i in range(n - (1 << j) + 1):
                mx[j][i] = max(mx[j - 1][i], mx[j - 1][i + half])
                mn[j][i] = min(mn[j - 1][i], mn[j - 1][i + half])

        def val(l, r):
            j = (r - l + 1).bit_length() - 1
            off = r - (1 << j) + 1
            return max(mx[j][l], mx[j][off]) - min(mn[j][l], mn[j][off])

        heap = [(-val(0, n - 1), 0, n - 1)]
        seen = {(0, n - 1)}
        ans = 0
        for _ in range(k):
            negv, l, r = heapq.heappop(heap)
            ans += -negv
            for nl, nr in ((l + 1, r), (l, r - 1)):
                if nl <= nr and (nl, nr) not in seen:
                    seen.add((nl, nr))
                    heapq.heappush(heap, (-val(nl, nr), nl, nr))
        return ans


sol = Solution()
print(sol.maxTotalValue([11, 8], 3))