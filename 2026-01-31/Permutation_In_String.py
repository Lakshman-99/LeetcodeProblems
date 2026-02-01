class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1Freq = [0] * 26
        s2Freq = [0] * 26

        for c in s1:
            s1Freq[ord(c) - ord('a')] += 1

        l, k = 0, len(s1)
        for r, c in enumerate(s2):
            if (r - l + 1) > k:
                s2Freq[ord(s2[l]) - ord('a')] -= 1
                l += 1

            s2Freq[ord(c) - ord('a')] += 1

            if (r - l + 1) == k and s1Freq == s2Freq:
                return True

        return False

sol = Solution()
print(sol.checkInclusion("ab", "eidboaooo"))