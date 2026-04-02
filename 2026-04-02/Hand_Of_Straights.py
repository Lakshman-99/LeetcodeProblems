from collections import Counter
from typing import List


class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False

        count = Counter(hand)

        for key in hand:
            if not count[key]:
                continue

            start = key
            while count[start - 1]:
                start -= 1

            while start <= key:
                while count[start]:
                    for new_key in range(start, start + groupSize):
                        if not count[new_key]:
                            return False

                        count[new_key] -= 1
                start += 1

        return True


sol = Solution()
print(sol.isNStraightHand([5,5,4,3,2,1], 2))