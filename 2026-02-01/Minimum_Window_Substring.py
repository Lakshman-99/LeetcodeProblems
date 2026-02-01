from collections import defaultdict
from typing import List


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == t:
            return s

        if len(t) > len(s):
            return ""

        targetFreq = defaultdict(int)
        for c in t:
            targetFreq[c] += 1

        runFreq = defaultdict(int)
        l = minLeft = 0
        minLen = float('inf')
        k = len(t)
        for r, c in enumerate(s):
            runFreq[c] += 1
            if targetFreq[c] != 0 and runFreq[c] <= targetFreq[c]:
                k -= 1

            while k == 0:
                if r - l + 1 < minLen:
                    minLen = r - l + 1
                    minLeft = l

                cl = s[l]
                runFreq[cl] -= 1
                if targetFreq[cl] != 0 and runFreq[cl] < targetFreq[cl]:
                    k += 1

                l += 1

        if minLen == float('inf'):
            return ""

        return s[minLeft:minLeft+minLen]


sol = Solution()
print(sol.minWindow("ADOBECODEBANC", "ABC"))