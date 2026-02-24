
class Solution:
    def countSubstrings(self, s: str) -> int:
        def is_palindrome(l, r):
            while l >= 0 and r <= len(s)-1:
                if s[l] != s[r]:
                    return False
                l, r = l-1, r+1

            return True

        ans = 0
        for i in range(len(s)):
            if is_palindrome(i, i):
                ans += 1

            if is_palindrome(i, i+1):
                ans += 1

        return ans


sol = Solution()
print(sol.countSubstrings("aaa"))