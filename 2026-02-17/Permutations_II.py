from collections import Counter
from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        count = Counter(nums)

        def dfs(cur_list):
            if len(cur_list) == len(nums):
                res.append(cur_list[:])
                return

            for num in count:
                if count[num] > 0:
                    cur_list.append(num)
                    count[num] -= 1
                    dfs(cur_list)
                    count[num] += 1
                    cur_list.pop()

        dfs([])
        return res


sol = Solution()
print(sol.permuteUnique([1,1,2,2]))