class Solution:
    def validPalindrome(self, s: str) -> bool:
        if not s:
            return False

        def isValid(left, right):
            while left < right:
                if s[left] != s[right]:
                    return False

                left += 1
                right -= 1

            return True

        l, r = 0, len(s)-1
        while l < r:
            if s[l] != s[r]:
                return isValid(l, r-1) or isValid(l+1, r)

            l += 1
            r -= 1

        return True


sol = Solution()
print(sol.validPalindrome("daba"))