from typing import List


class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        a, b = 0, 0
        i, j = 0, len(piles) - 1
        turn = 0

        while i < j:
            if turn & 1:
                if piles[i] > piles[j]:
                    b += piles[i]
                    i += 1
                else:
                    b += piles[j]
                    j -= 1
            else:
                if piles[i] > piles[j]:
                    a += piles[i]
                    i += 1
                else:
                    a += piles[j]
                    j -= 1

            turn += 1

        return a > b


sol = Solution()
print(sol.stoneGame([3,2,10,4]))