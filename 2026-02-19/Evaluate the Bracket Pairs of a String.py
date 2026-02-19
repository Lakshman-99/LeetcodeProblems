from typing import List


class Solution:
    def evaluate(self, s: str, knowledge: List[List[str]]) -> str:
        k_map = {key: val for key, val in knowledge}

        res = []
        idx = 0
        while idx < len(s):
            if s[idx] == '(':
                start = idx + 1
                end = start
                while s[end] != ')':
                    end += 1

                replacement = k_map.get(s[start:end], "?")
                res.append(replacement)
                idx = end
            else:
                res.append(s[idx])

            idx += 1

        return "".join(res)




sol = Solution()
print(sol.evaluate("(a)(a)(a)aaa", [["a","yes"]]))