from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        new_intervals = [intervals[0]]

        for start, end in intervals:
            prev_end = new_intervals[-1][1]

            if start <= prev_end:
                new_intervals[-1][1] = max(end, prev_end)
            else:
                new_intervals.append([start, end])

        return new_intervals


sol = Solution()
print(sol.merge([[1,3],[2,6],[8,10],[15,18]]))
print(sol.merge([[1,9], [2,3],[4,5]]))
print(sol.merge([[4,7],[1,4]]))
