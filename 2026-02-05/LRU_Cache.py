
class Node:
    def __init__(self, key=None, val=None, next=None, prev=None):
        self.key = key
        self.val = val
        self.next = next
        self.prev = prev

class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.head = Node()
        self.tail = Node()

        self.head.next = self.tail
        self.tail.prev = self.head
        self.hm = {}

    def _delete_key(self, key):
        node = self.hm[key]
        node.prev.next = node.next
        node.next.prev = node.prev
        self.hm.pop(key)

    def _add_key(self, key, val):
        node = Node(key, val, self.head.next, self.head)
        if self.head.next:
            self.head.next.prev = node

        self.head.next = node
        self.hm[key] = node

    def get(self, key: int) -> int:
        if key not in self.hm:
            return -1

        node = self.hm[key]
        self._delete_key(key)
        self._add_key(key, node.val)

        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.hm:
            self._delete_key(key)
            self.cap += 1
        elif self.cap == 0:
            self._delete_key(self.tail.prev.key)
            self.cap += 1

        self.cap -= 1
        self._add_key(key, value)
        return


# Your LRUCache object will be instantiated and called as such:
# 1. Initialize Cache with capacity 2
cache = LRUCache(2)
print(f"Init: capacity 2")

# 2. Put (1, 1)
cache.put(1, 1)
print(f"put(1, 1):  Cache is now {cache.hm.keys()}")

# 3. Put (2, 2)
cache.put(2, 2)
print(f"put(2, 2):  Cache is now {cache.hm.keys()}")

# 4. Get 1 -> Expected: 1
res1 = cache.get(1)
print(f"get(1):     Result = {res1} (Expected: 1)")

# 5. Put (3, 3) -> Should evict key 2 (since 1 was just accessed)
cache.put(3, 3)
print(f"put(3, 3):  Cache is now {cache.hm.keys()} (Evicted 2)")

# 6. Get 2 -> Expected: -1
res2 = cache.get(2)
print(f"get(2):     Result = {res2} (Expected: -1)")

# 7. Put (4, 4) -> Should evict key 1
cache.put(4, 4)
print(f"put(4, 4):  Cache is now {cache.hm.keys()} (Evicted 1)")

# 8. Get 1 -> Expected: -1
res3 = cache.get(1)
print(f"get(1):     Result = {res3} (Expected: -1)")

# 9. Get 3 -> Expected: 3
res4 = cache.get(3)
print(f"get(3):     Result = {res4} (Expected: 3)")

# 10. Get 4 -> Expected: 4
res5 = cache.get(4)
print(f"get(4):     Result = {res5} (Expected: 4)")