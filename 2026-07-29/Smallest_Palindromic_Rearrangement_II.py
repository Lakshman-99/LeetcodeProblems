class Solution:
    def smallestPalindrome(self, s: str, k: int) -> str:
        n = len(s)
        h = n // 2
        mid = s[h] if n % 2 == 1 else ""

        proc = "".join(sorted(s[:h]))
        if (proc and len(proc) < k) or (not proc and mid and k > 1):
            return ""
        k -= 1
        proc = proc[k:] + proc[:k]

        return proc + mid + proc[::-1]


sol = Solution()
print(sol.smallestPalindrome("nyggyn", 4))