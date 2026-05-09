from itertools import accumulate
from typing import List


class SegmentTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (4 * n)
        self.lazy = [0] * (4 * n)

    def _update(self, i, left, right, start, end, val):
        if self.lazy[i] != 0:
            self.tree[i] += (right - left + 1) * self.lazy[i]
            if left != right:
                self.lazy[2 * i + 1] = self.lazy[i]
                self.lazy[2 * i + 2] = self.lazy[i]
            self.lazy[i] = 0

        if left > end or right < start:
            return

        if left >= start and right <= end:
            self.tree[i] += (right - left + 1) * val
            if left != right:
                self.lazy[2 * i + 1] += val
                self.lazy[2 * i + 2] += val
            return

        mid = (left + right) // 2
        self._update(2 * i + 1, left, mid, start, end, val)
        self._update(2 * i + 2, mid + 1, right, start, end, val)
        self.tree[i] = self.tree[2 * i + 1] + self.tree[2 * i + 2]

    def update_range(self, start, end, val):
        self._update(0, 0, self.n-1, start, end, val)

    def _query(self, i, start, end, tar):
        if start == end:
            return self.tree[i] + self.lazy[i]

        if self.lazy[i] != 0:
            self.tree[i] += (end - start + 1) * self.lazy[i]
            self.lazy[2 * i + 1] += self.lazy[i]
            self.lazy[2 * i + 2] += self.lazy[i]
            self.lazy[i] = 0

        mid = (end + start) // 2
        if tar <= mid:
            return self._query(2 * i + 1, start, mid, tar)
        else:
            return self._query(2 * i + 2, mid + 1, end, tar)

    def get_array(self):
        return [self._query(0, 0, self.n-1, i) for i in range(self.n)]


class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        d = [0] * length
        for l, r, c in updates:
            d[l] += c
            if r + 1 < length:
                d[r + 1] -= c
        return list(accumulate(d))

    def getModifiedArray2(self, length: int, updates: List[List[int]]) -> List[int]:
        st = SegmentTree(length)
        for start, end, val in updates:
            st.update_range(start, end, val)
        return st.get_array()


sol = Solution()
length = 5
updates = [[1,3,2],[2,4,3],[0,2,-2]]
print(sol.getModifiedArray(length, updates))
