from collections import deque


class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: list[int], informTime: list[int]) -> int:
        adj = [[] for _ in range(n)]
        for emp, mng in enumerate(manager):
            if mng == -1:
                continue
            adj[mng].append(emp)

        total_time = 0
        q = deque([(headID, 0)])
        while q:
            mng, elapsed = q.popleft()
            total_time = max(total_time, elapsed)
            for emp in adj[mng]:
                q.append((emp, elapsed + informTime[mng]))

        return total_time


sol = Solution()
print(sol.numOfMinutes(11, 4, [5,9,6,10,-1,8,9,1,9,3,4], [0,213,0,253,686,170,975,0,261,309,337]))
