from collections import deque


class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        r = deque()
        d = deque()
        n = len(senate)

        for i, s in enumerate(senate):
            if s == 'R':
                r.append(i)
            else:
                d.append(i)

        while r and d:
            r_ind = r.popleft()
            d_ind = d.popleft()

            if r_ind < d_ind:
                r.append(r_ind + n)
            else:
                d.append(d_ind + n)

        return "Radiant" if r else "Dire"


sol = Solution()
print(sol.predictPartyVictory("DRRDRDRDRDDRDRDR"))
