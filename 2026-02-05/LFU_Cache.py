class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.freq = 1
        self.next = None
        self.prev = None

class DLL:
    def __init__(self):
        self.head, self.tail = Node(None, None), Node(None, None)
        self.head.next, self.tail.prev = self.tail, self.head

    def add_node(self, node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node

    def remove_node(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
        return node

    def is_empty(self):
        return self.head.next == self.tail


class LFUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.minFreq = 1
        self.nodeMap = {}
        self.freqMap = {}

    def _update_node(self, node):
        old_dll = self.freqMap[node.freq]
        old_dll.remove_node(node)

        if old_dll.is_empty() and node.freq == self.minFreq:
            self.minFreq += 1

        node.freq += 1
        if node.freq not in self.freqMap:
            self.freqMap[node.freq] = DLL()

        self.freqMap[node.freq].add_node(node)

    def get(self, key: int) -> int:
        if key not in self.nodeMap:
            return -1

        node = self.nodeMap[key]
        self._update_node(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if self.cap <= 0:
            return

        if key in self.nodeMap:
            node = self.nodeMap[key]
            node.val = value
            self._update_node(node)
        else:
            if len(self.nodeMap) >= self.cap:
                dll = self.freqMap[self.minFreq]
                evict = dll.remove_node(dll.tail.prev)
                self.nodeMap.pop(evict.key)

            new_node = Node(key, value)
            self.nodeMap[key] = new_node
            self.minFreq = 1
            if 1 not in self.freqMap:
                self.freqMap[1] = DLL()

            self.freqMap[1].add_node(new_node)


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)