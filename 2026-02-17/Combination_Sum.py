from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(idx, cur_list, t):
            if t == 0:
                res.append(list(cur_list))
                return

            for i in range(idx, len(candidates)):
                if t - candidates[i] < 0:
                    break

                cur_list.append(candidates[i])
                dfs(i, cur_list, t - candidates[i])
                cur_list.pop()

        dfs(0, [], target)
        return res


sol = Solution()
print(sol.combinationSum([2,3,6,7], 7))