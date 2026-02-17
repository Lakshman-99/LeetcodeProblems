from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        def dfs(idx, cur_list):
            if len(cur_list) == k:
                res.append(list(cur_list))
                return

            for i in range(idx, n - (k - len(cur_list)) + 2):
                cur_list.append(i)
                dfs(i + 1, cur_list)
                cur_list.pop()

        dfs(1, [])
        return res


sol = Solution()
print(sol.combine(4, 2))