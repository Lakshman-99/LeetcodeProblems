class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 1:
            return n
        prev = 0
        cur = 1

        for i in range(1, n+1):
            temp = cur
            cur += prev
            prev = temp

        return cur


sol = Solution()
print(sol.climbStairs(2))