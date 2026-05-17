class Solution:
    def countKthRoots(self, l: int, r: int, k: int) -> int:
        fact1 = 0
        while fact1 ** k <= r:
            fact1 += 1

        fact2 = 1
        while fact2 ** k <= l:
            fact2 += 1

        return fact1 - fact2


sol = Solution()
print(sol.countKthRoots(1, 9, 3))