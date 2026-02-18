from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        def dfs(idx, cur_list):
            res.append(cur_list[:])
            for i in range(idx, len(nums)):
                if i > idx and nums[i-1] == nums[i]:
                    break

                cur_list.append(nums[i])
                dfs(i + 1, cur_list)
                cur_list.pop()

        dfs(0, [])
        return res


sol = Solution()
print(sol.subsetsWithDup([1,2,2]))