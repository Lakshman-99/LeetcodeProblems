from collections import defaultdict
from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seq = defaultdict(int)
        for i in range(len(s) - 9):
            seq[s[i:i + 10]] += 1

        res = []
        for k, v in seq.items():
            if v > 1:
                res.append(k)

        return res


sol =Solution()
print(sol.findRepeatedDnaSequences("AAAAAAAAAA"))