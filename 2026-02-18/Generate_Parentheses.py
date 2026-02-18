from collections import Counter
from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def dfs(open, closed, cur_str):
            if len(cur_str) == 2 * n:
                res.append(cur_str)
                return

            if open < n:
                dfs(open + 1, closed, cur_str + "(")

            if closed < open:
                dfs(open, closed + 1, cur_str + ")")

        dfs(0, 0, "")
        return res


sol = Solution()
print(sol.generateParenthesis(3))