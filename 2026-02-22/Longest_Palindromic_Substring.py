class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)-1
        start, end = 0, 0
        max_len = 0
        for i in range(n):
            l, r = i, i
            while l >= 0 and r <= n and s[l] == s[r]:
                if max_len < r-l+1:
                    max_len = r-l+1
                    start, end = l, r
                l -= 1
                r += 1

            l, r = i, i+1
            while l >= 0 and r <= n and s[l] == s[r]:
                if max_len < r - l + 1:
                    max_len = r - l + 1
                    start, end = l, r
                l -= 1
                r += 1

        return s[start:end+1]


sol = Solution()
print(sol.longestPalindrome("babbab"))