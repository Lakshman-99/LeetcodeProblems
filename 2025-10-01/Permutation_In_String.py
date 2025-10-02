class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        freq = [0] * 256
        runFreq = [0] * 256

        for c in s1:
            freq[ord(c)] += 1

        j = len(s1)
        for i in range(j):
            runFreq[ord(s2[i])] += 1

        for i in range(j, len(s2)):
            if freq == runFreq:
                return True
            else:
                runFreq[ord(s2[i])] += 1
                runFreq[ord(s2[i-j])] -= 1

        return freq == runFreq



sol = Solution()
print(sol.checkInclusion("adc", "dcda"))