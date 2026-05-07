from typing import List

class SegmentTree:
    def __init__(self, nums: List[int]):
        self.n = len(nums)
        self.nums = nums
        self.tree = [0] * (4 * self.n)
        self._build(0, 0, self.n-1)

    def _build(self, index, left, right) -> None:
        if left == right:
            self.tree[index] = self.nums[left]
            return

        mid = (left + right) // 2
        self._build(2 * index + 1, left, mid)
        self._build(2 * index + 2, mid+1, right)
        self.tree[index] = self.tree[2 * index + 1] + self.tree[2 * index + 2]

    def _update(self, i, left, right, index, val) -> None:
        if left == right:
            self.tree[i] = val
            return

        mid = (left + right) // 2
        if index <= mid:
            self._update(2 * i + 1, left, mid, index, val)
        else:
            self._update(2 * i + 2, mid+1, right, index, val)

        self.tree[i] = self.tree[2 * i + 1] + self.tree[2 * i + 2]

    def update(self, index, val) -> None:
        self._update(0, 0, self.n-1, index, val)

    def _query(self, i, left, right, start, end) -> int:
        if right < start or left > end:
            return 0

        if left >= start and right <= end:
            return self.tree[i]

        mid = (left + right) // 2
        return self._query(2 * i + 1, left, mid, start, end) + self._query(2 * i + 2, mid+1, right, start, end)

    def query(self, start, end) -> int:
        return self._query(0, 0, self.n-1, start, end)

class NumArray:

    def __init__(self, nums: List[int]):
        self.segment_tree = SegmentTree(nums)

    def update(self, index: int, val: int) -> None:
        self.segment_tree.update(index, val)

    def sumRange(self, left: int, right: int) -> int:
        return self.segment_tree.query(left, right)


n = NumArray([1, 3, 5])