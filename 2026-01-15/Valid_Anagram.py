
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if s == t:
            return True

        if not s or not t or len(s) != len(t):
            return False

        answer = False

        # brute force
        # answer = sorted(s) == sorted(t)

        # optimal
        m1, m2 = {}, {}
        for i in range(len(s)):
            m1[s[i]] = m1.get(s[i], 0) + 1
            m2[t[i]] = m2.get(t[i], 0) + 1

        answer = m1 == m2

        return answer


sol = Solution()
print(sol.isAnagram("lamp", "palm"))