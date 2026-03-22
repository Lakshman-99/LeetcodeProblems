from collections import defaultdict
from typing import List


class DetectSquares:

    def __init__(self):
        self.points_freq = defaultdict(int)
        self.points = []

    def add(self, point: List[int]) -> None:
        self.points_freq[tuple(point)] += 1
        self.points.append(tuple(point))

    def count(self, point: List[int]) -> int:
        px, py = point
        res = 0

        for x, y in self.points:
            if (abs(px - x) != abs(py - y)) or x == px or y == py:
                continue

            res += self.points_freq[(x, py)] * self.points_freq[(px, y)]

        return res
