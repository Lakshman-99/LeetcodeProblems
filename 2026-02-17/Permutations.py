from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(idx):
            if idx == len(nums):
                res.append(nums[:])
                return

            for i in range(idx, len(nums)):
                nums[idx], nums[i] = nums[i], nums[idx]
                dfs(idx+1)
                nums[idx], nums[i] = nums[i], nums[idx]

        dfs(0)
        return res


sol = Solution()
print(sol.permute([1,2,3]))