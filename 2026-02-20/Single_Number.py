from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        black_sheep = 0
        for num in nums:
            black_sheep ^= num

        return black_sheep
