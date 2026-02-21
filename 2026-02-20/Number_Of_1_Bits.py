class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        for i in range(32):
            if n & (1 << i):
                ans += 1

        return ans


sol = Solution()
print(sol.hammingWeight(11))