
class Solution:
    def countSubstrings(self, s: str) -> int:
        def is_palindrome(l, r):
            palindromes = 0
            while l >= 0 and r <= len(s)-1:
                if s[l] != s[r]:
                    break
                l, r = l-1, r+1
                palindromes += 1

            return palindromes

        ans = 0
        for i in range(len(s)):
            ans += is_palindrome(i, i) + is_palindrome(i, i+1)

        return ans


sol = Solution()
print(sol.countSubstrings("aaa"))