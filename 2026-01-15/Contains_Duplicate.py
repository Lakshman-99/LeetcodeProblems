from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        if not nums:
            return False

        answer = False
        n = len(nums)

        # brute force - O(N^2)
        # for i in range(n):
        #     for j in range(i+1, n):
        #         if nums[i] == nums[j]:
        #             answer = True
        #             break

        # Optimised - O(nLog(n))
        # nums.sort()
        # for i in range(1, n):
        #     if nums[i-1] == nums[i]:
        #         answer = True
        #         break

        # Optimal - O(N)
        # visited = set()
        # for num in nums:
        #     if num in visited:
        #         answer = True
        #         break
        #
        #     visited.add(num)

        # Super Optimized - O(N)
        answer = n == len(set(nums))

        return answer


sol = Solution()
print(sol.containsDuplicate([1, 2, 3]))