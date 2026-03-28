from typing import List


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change = [0] * 3

        for bill in bills:
            if bill == 5:
                change[0] += 1
            elif bill == 10:
                change[1] += 1
                if change[0] == 0:
                    return False
                change[0] -= 1
            elif bill == 20:
                change[2] += 1
                if change[1] > 0 and change[0] > 0:
                    change[1] -= 1
                    change[0] -= 1
                elif change[0] > 2:
                    change[0] -= 3
                else:
                    return False

        return True


sol = Solution()
print(sol.lemonadeChange([5,5,5,5,20,20,5,5,20,5]))