class Solution:
    def minCapability(self, nums: list[int], k: int) -> int:
        n = len(nums)

        def solve(i, cur):
            if i >= n:
                return 0

            rob = max(nums[i], solve(i+2, cur + 1))
            not_rob = solve(i+1, cur)
            if not_rob == 0:
                not_rob = float('inf')

            return min(rob, not_rob) if cur >= k else float('inf')

        return solve(0, 0)


sol = Solution()
print(sol.minCapability([2,7,9,3,1], 2))