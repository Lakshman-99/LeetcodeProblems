from collections import defaultdict


class TimeMap:

    def __init__(self):
        self.map = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.map[key]

        l, r = 0, len(values) - 1
        while l <= r:
            m = l + (r-l) // 2
            if values[m][0] <= timestamp:
                res = values[m][1]
                l = m + 1
            else:
                r = m - 1

        return res


# Your TimeMap object will be instantiated and called as such:
obj = TimeMap()
obj.set("foo", "bar", 1)
print(obj.get("foo", 1))
print(obj.get("foo", 3))
print(obj.set("foo", "bar2", 4))
print(obj.get("foo", 4))
print(obj.get("foo", 5))
