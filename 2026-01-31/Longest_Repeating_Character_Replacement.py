from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = defaultdict(int)
        maxFreq = ans = l = 0

        for r, c in enumerate(s):
            freq[c] += 1
            maxFreq = max(maxFreq, freq[c])

            while (r - l + 1) - maxFreq > k:
                freq[s[l]] -= 1
                l += 1

            ans = max(ans, r - l + 1)

        return ans


sol = Solution()
print(sol.characterReplacement("AABABBA", 1))