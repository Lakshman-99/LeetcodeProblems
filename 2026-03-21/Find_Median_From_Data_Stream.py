from collections import deque


class MedianFinder:

    def __init__(self):
        self.cap = 0
        self.data = deque()

    def addNum(self, num: int) -> None:
        self.cap += 1
        self.data.append(num)

        if self.cap % 2 == 1:
            self.data.popleft()
        


    def findMedian(self) -> float:

