import heapq
from collections import Counter
from typing import List


class Solution:
    def reorganizeString(self, s: str) -> str:
        freq = Counter(s)
        heap = []

        for ch, count in freq.items():
            heapq.heappush(heap, (-count, ch))

        prev = None
        res = []
        while heap or prev:
            if prev and not heap:
                return ""

            freq, ch = heapq.heappop(heap)
            res.append(ch)
            freq += 1

            if prev:
                heapq.heappush(heap, (prev[0], prev[1]))
                prev = None

            if freq:
                prev = [freq, ch]

        return "".join(res)


sol = Solution()
print(sol.reorganizeString("aaab"))