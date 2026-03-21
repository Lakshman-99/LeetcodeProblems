import heapq


class MedianFinder:

    def __init__(self):
        self.low = []  # max-heap
        self.high = []  # min-heap

    def addNum(self, num: int) -> None:
        heapq.heappush(self.low, -num)
        heapq.heappush(self.high, -heapq.heappop(self.low))

        if len(self.high) > len(self.low):
            heapq.heappush(self.low, -heapq.heappop(self.high))

    def findMedian(self) -> float:
        if len(self.low) > len(self.high):
            return -self.low[0] * 1.0

        return (-self.low[0] + self.high[0]) / 2.0


cmd = ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
data = [[],[1],[2],[],[3],[]]
sol = MedianFinder()

for c, d in zip(cmd, data):
    if c == "addNum":
        sol.addNum(d[0])
    elif c == "findMedian":
        sol.findMedian()