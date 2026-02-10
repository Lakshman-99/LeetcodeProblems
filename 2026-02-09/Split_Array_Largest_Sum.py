from typing import List


class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def canSplit(m):
            split = 1
            runningSum = 0
            for n in nums:
                runningSum += n
                if runningSum > m:
                    runningSum = n
                    split += 1

            return split <= k

        l, r = max(nums), sum(nums)
        res = r
        while l <= r:
            m = l + (r - l) // 2
            if canSplit(m):
                res = m
                r = m - 1
            else:
                l = m + 1

        return res

sol = Solution()
print(sol.splitArray([7,2,5,10,8], 2))
