from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        res = 0
        prev_end = intervals[0][1]

        for start, end in intervals[1:]:
            if start >= prev_end:
                prev_end = end
            else:
                res += 1
                prev_end = min(end, prev_end)

        return res


sol = Solution()
print(sol.eraseOverlapIntervals([[1,3],[2,6],[8,10],[15,18]]))
print(sol.eraseOverlapIntervals([[1,9], [2,3],[4,5]]))
print(sol.eraseOverlapIntervals([[4,7],[1,4]]))
