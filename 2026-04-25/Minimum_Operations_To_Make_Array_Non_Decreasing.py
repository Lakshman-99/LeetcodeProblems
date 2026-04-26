import heapq


class Solution:
    def minOperations(self, nums: list[int]) -> int:
        n = len(nums)
        min_op = i = 0

        while i < n:
            if i+1 < n and nums[i] > nums[i + 1]:
                j = i + 1
                cur_max = diff = 0
                while j + 1 < n and nums[j + 1] < nums[i]:
                    diff += abs(nums[j] - nums[j+1])
                    cur_max = max(cur_max, nums[j])
                    j += 1

                if cur_max == diff == 0:
                    min_op += nums[i] - nums[j]
                else:
                    if j == n - 1:
                        cur_max = max(cur_max, nums[j])
                    min_op += diff + nums[i] - cur_max
                i = j - 1
            i += 1

        return min_op


sol = Solution()
print(sol.minOperations([7,26,2,25,27]))
print(sol.minOperations([10,24,1,11,3]))