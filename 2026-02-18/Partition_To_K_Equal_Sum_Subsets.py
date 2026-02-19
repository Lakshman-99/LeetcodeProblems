from typing import List


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if sum(nums) % k != 0:
            return False

        nums.sort(reverse=True)
        target_sum = sum(nums) // k
        used = [False] * len(nums)

        def dfs(i, k, cur_sum):
            if k == 0:
                return True

            if cur_sum == target_sum:
                return dfs(0, k-1, 0)

            for j in range(i, len(nums)):
                if used[j] or cur_sum + nums[j] > target_sum:
                    continue

                used[j] = True
                if dfs(i+1, k, cur_sum + nums[j]):
                    return True

                used[j] = False

                if cur_sum == 0:
                    break

            return False

        return dfs(0, k, 0)


sol = Solution()
print(sol.canPartitionKSubsets([4,3,2,3,5,2,1], 4))