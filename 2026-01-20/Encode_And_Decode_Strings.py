from typing import List


class Solution:

    def encode(self, strs: List[str]) -> str:
        res = []
        for s in strs:
            res.append(f"{len(s)}#{s}")
        return "".join(res)

    def decode(self, s: str) -> List[str]:
        answer = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != "#":
                j+=1

            length = int(s[i:j])
            i = j + 1
            answer.append(s[i : i + length])
            i += length

        return answer



sol = Solution()
print(sol.encode(["Hel##lo1","1#1"]))
print(sol.decode(sol.encode(["Hel##lo1","World","1#1"])))