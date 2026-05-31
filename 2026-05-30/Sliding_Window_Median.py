import heapq
from collections import deque, defaultdict
from typing import List


class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l = balance = 0
        minHeap, maxHeap, res = [], [], []
        deleted = defaultdict(int)

        for r, num in enumerate(nums):
            if maxHeap and num <= -maxHeap[0]:
                heapq.heappush(maxHeap, -num)
                balance += 1
            else:
                heapq.heappush(minHeap, num)
                balance -= 1

            if r >= k:
                deleted[nums[l]] += 1
                balance += -1 if (maxHeap and nums[l] <= -maxHeap[0]) else 1
                l += 1

            if balance > 1:
                heapq.heappush(minHeap, -heapq.heappop(maxHeap))
                balance -= 2
            elif balance < 0:
                heapq.heappush(maxHeap, -heapq.heappop(minHeap))
                balance += 2

            while maxHeap and deleted[-maxHeap[0]]:
                deleted[-maxHeap[0]] -= 1
                heapq.heappop(maxHeap)

            while minHeap and deleted[minHeap[0]]:
                deleted[minHeap[0]] -= 1
                heapq.heappop(minHeap)

            if r >= k - 1:
                res.append(-maxHeap[0] if k % 2 else (minHeap[0] - maxHeap[0]) / 2.0)

        return res


sol = Solution()
print(sol.medianSlidingWindow([1,3,-1,-3,5,3,6,7], 3))