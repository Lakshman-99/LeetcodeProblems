from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        def dfs(i):
            res = 1
            for j in range(i+1, len(nums)):
                if nums[j] > nums[i]:
                    res = max(res, 1 + dfs(j))

            return res

        n = len(nums)
        cache = [1] * n

        for i in range(n-1,-1,-1):
            for j in range(i+1, n):
                if nums[i] < nums[j]:
                    cache[i] = max(cache[i], 1 + cache[j])

        return max(cache)


sol = Solution()
print(sol.lengthOfLIS([4,10,4,3,8,9]))