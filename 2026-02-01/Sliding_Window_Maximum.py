import heapq
from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        l = 0
        maxQueue = deque()
        for r, num in enumerate(nums):
            while maxQueue and nums[maxQueue[-1]] < num:
                maxQueue.pop()
            maxQueue.append(r)

            if l > maxQueue[0]:
                maxQueue.popleft()

            if r + 1 >= k:
                res.append(nums[maxQueue[0]])
                l += 1

        return res


sol = Solution()
print(sol.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))