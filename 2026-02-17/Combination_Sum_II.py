from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()

        def dfs(idx, cur_list, t):
            if t == 0:
                res.append(list(cur_list))
                return

            for i in range(idx, len(candidates)):
                if i > idx and candidates[i] == candidates[i-1]:
                    continue

                if t - candidates[i] < 0:
                    break

                cur_list.append(candidates[i])
                dfs(i+1, cur_list, t - candidates[i])
                cur_list.pop()

        dfs(0, [], target)
        return res


sol = Solution()
print(sol.combinationSum2([10,1,2,7,6,1,5], 8))