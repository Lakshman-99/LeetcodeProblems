from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_seen = {}
        for i, c in enumerate(s):
            last_seen[c] = i

        res = []
        size = end = 0
        for i, c in enumerate(s):
            size += 1
            end = max(end, last_seen[c])

            if i == end:
                res.append(size)
                size = 0

        return res


sol = Solution()
print(sol.partitionLabels("ababcbacadefegdehijhklij"))