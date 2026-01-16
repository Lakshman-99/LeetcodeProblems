from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        prefix = strs[0]
        for i in range(1, len(strs)):
            word = strs[i]
            while not word.startswith(prefix):
                prefix = prefix[:len(prefix)-1]

        return prefix


sol = Solution()
print(sol.longestCommonPrefix(["ab", "a"]))