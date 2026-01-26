from typing import List


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        if limit == 0 or not people:
            return 0

        people.sort()
        boat = 0
        l, r = 0, len(people) - 1
        while l <= r:
            s = people[l] + people[r]
            if s <= limit:
                l += 1

            r -= 1
            boat += 1

        return boat


sol = Solution()
print(sol.numRescueBoats([3,5,3,4], 5))