from collections import defaultdict
from typing import List

class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key=lambda x: x.start)
        events = defaultdict(int)

        for interval in intervals:
            events[interval.start] += 1
            events[interval.end] -= 1

        rooms = max_rooms = 0
        for event in sorted(events.keys()):
            rooms += events[event]
            max_rooms = max(max_rooms, rooms)

        return max_rooms


sol = Solution()
print(sol.minMeetingRooms([Interval(20,40),Interval(5,10),Interval(2,20)]))
