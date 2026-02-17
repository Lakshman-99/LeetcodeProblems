from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(i, cur_list):
            if i == len(nums):
                res.append(list(cur_list))
                return

            cur_list.append(nums[i])
            dfs(i+1, cur_list)
            cur_list.pop()
            dfs(i+1, cur_list)

        dfs(0, [])
        return res


sol = Solution()
print(sol.subsets([1,2,3]))