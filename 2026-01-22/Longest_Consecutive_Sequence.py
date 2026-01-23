from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        max_seq = 1
        unique = set(nums)

        for num in unique:
            if num-1 in unique:
                continue

            cur_num = num
            cur_seq = 1
            while cur_num+1 in unique:
                cur_num += 1
                cur_seq += 1

            max_seq = max(max_seq, cur_seq)

        return max_seq


sol = Solution()
print(sol.longestConsecutive([100,4,200,1,3,2]))