class Solution:
    def minAdjacentSwaps(self, nums: list[int], a: int, b: int) -> int:
        n = len(nums)
        i, j = 0, n - 1

        s = 0
        while i < j:
            while i < n and nums[i] <= a:
                i += 1
            i -= 1
            while j >= 0 and nums[j] >= b:
                j -= 1

            if i >= j:
                break

            d = j - i
            s += d * 2 - 1
            nums[i], nums[j] = nums[j], nums[i]
            i, j = i + 1, j - 1

        return s

sol = Solution()
print(sol.minAdjacentSwaps([1,3,2,4,5,6], 3, 4))