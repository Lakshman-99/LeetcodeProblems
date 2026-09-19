from collections import deque


class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: list[int], informTime: list[int]) -> int:
        adj = [[] for _ in range(n)]
        for emp, mng in enumerate(manager):
            if mng == -1:
                continue
            adj[mng].append(emp)

        min_time = 0
        q = deque([headID])
        while q:
            cur_len = len(q)
            max_time = 0
            for _ in range(cur_len):
                mng = q.popleft()
                max_time = max(max_time, informTime[mng])

                for emp in adj[mng]:
                    q.append(emp)

            min_time += max_time

        return min_time


sol = Solution()
print(sol.numOfMinutes(11, 4, [5,9,6,10,-1,8,9,1,9,3,4], [0,213,0,253,686,170,975,0,261,309,337]))
