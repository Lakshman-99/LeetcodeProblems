from functools import cache


class Solution:
    def maxAlternatingSum(self, nums: list[int], k: int) -> int:
        n = len(nums)

        @cache
        def solve(i, need_greater):
            best = 0

            for j in range(i+k, n):
                if need_greater:
                    if nums[j] > nums[i]:
                        best = max(best, nums[j] + solve(j, False))
                else:
                    if nums[j] < nums[i]:
                        best = max(best, nums[j] + solve(j, True))

            return best

        ans = 0
        for i in range(n):
            ans = max(ans, nums[i] + max(solve(i, True), solve(i, False)))

        return ans

    def maxAlternatingSum2(self, nums: list[int], k: int) -> int:
        n = len(nums)

        @cache
        def solve(i, prev, need_greater):
            if i >= n:
                return 0

            best = solve(i+1, prev, need_greater)
            if prev == -1:
                best = max(best, nums[i] + solve(i+k, i, need_greater))
            elif need_greater and nums[i] > nums[prev]:
                best = max(best, nums[i] + solve(i+k, i, False))
            elif not need_greater and nums[i] < nums[prev]:
                best = max(best, nums[i] + solve(i+k, i, True))

            return best

        return max(solve(0, -1, True), solve(0, -1, False))


sol = Solution()
print(sol.maxAlternatingSum([3,5,4,2,4], 1))
print(sol.maxAlternatingSum([5,4,2], 2))