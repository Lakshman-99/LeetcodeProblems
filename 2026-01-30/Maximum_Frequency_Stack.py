from collections import defaultdict


class FreqStack:

    def __init__(self):
        self.freq = defaultdict(int)
        self.stack = [[]]

    def push(self, val: int) -> None:
        self.freq[val] += 1
        freq = self.freq[val]
        if freq == len(self.stack):
            self.stack.append([])

        self.stack[freq].append(val)

    def pop(self) -> int:
        ans = self.stack[-1].pop()
        self.freq[ans] -= 1
        if not self.stack[-1]:
            self.stack.pop()
        return ans



# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()