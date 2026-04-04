from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], ni: List[int]) -> List[List[int]]:
        new_intervals = []

        for i, (start, end) in enumerate(intervals):
            if ni[1] < start:
                new_intervals.append(ni)
                return new_intervals + intervals[i:]
            elif end < ni[0]:
                new_intervals.append([start, end])
            else:
                ni = [min(start, ni[0]), max(end, ni[1])]

        new_intervals.append(ni)
        return new_intervals


sol = Solution()
print(sol.insert([[1,9]], [2,5]))
print(sol.insert([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8]))