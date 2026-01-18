class MyHashMap:

    def __init__(self):
        self.size = 1007
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)
        bucket = self.buckets[index]

        for i in range(len(bucket)):
            if bucket[i][0] == key:
                bucket[i][1] = value
                return

        bucket.append([key, value])


    def get(self, key: int) -> int:
        index = self._hash(key)
        bucket = self.buckets[index]

        for k, v in bucket:
            if k == key:
                return v

        return -1

    def remove(self, key: int) -> None:
        index = self._hash(key)
        bucket = self.buckets[index]

        for i in range(len(bucket)):
            if bucket[i][0] == key:
                bucket.pop(i)
                return


# Your MyHashMap object will be instantiated and called as such:

key = 10
value = 99

obj = MyHashMap()
obj.put(key,value)
param_2 = obj.get(key)
obj.put(key, 100)
obj.get(key)
obj.remove(key)