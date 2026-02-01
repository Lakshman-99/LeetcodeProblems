
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        maxLen = l = 0
        for r, c in enumerate(s):
            if c in seen:
                l = max(l, seen[c] + 1)

            seen[c] = r
            maxLen = max(maxLen, r - l + 1)

        return len(s) if maxLen == -1 else maxLen


sol = Solution()
print(sol.lengthOfLongestSubstring("aab"))