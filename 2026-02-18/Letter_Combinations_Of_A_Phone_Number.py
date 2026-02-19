from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        num_pad = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        chosen = [num_pad[int(i)] for i in digits]
        k = len(digits)

        def dfs(i, cur_list):
            if len(cur_list) == k:
                res.append("".join(cur_list))
                return

            for c in chosen[i]:
                cur_list.append(c)
                dfs(i+1, cur_list)
                cur_list.pop()

        dfs(0, [])
        return res


sol = Solution()
print(sol.letterCombinations("2"))