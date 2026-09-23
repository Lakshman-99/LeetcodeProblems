class Solution:
    def minCapability(self, nums: list[int], k: int) -> int:
        n = len(nums)

        lo, hi = 1, max(nums)
        while lo < hi:
            mid = (hi + lo) // 2

            idx = rob = 0
            while idx < n:
                if nums[idx] <= mid:
                    rob += 1
                    idx += 2
                else:
                    idx += 1

            if rob >= k:
                hi = mid
            else:
                lo = mid + 1

        return lo


sol = Solution()
print(sol.minCapability([2,7,9,3,1], 2))