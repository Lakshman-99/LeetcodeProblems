class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        freq = [0] * 256
        runFreq = [0] * 256

        for c in s1:
            freq[ord(c)] += 1

        j = len(s1)
        for i in range(j):
            runFreq[ord(s2[i])] += 1

        for i in range(len(s2)):



sol = Solution()
sol.checkInclusion("ab", "eidbaooo")