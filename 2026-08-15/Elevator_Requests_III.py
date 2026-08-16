import heapq


class Solution:
    def elevatorRequests(self, n: int, start: int, req: list[list[int]]) -> int:
        req.sort()
        time = req[0][0]

        cur_req = []
        for at, floor in req:
            while cur_req and at < -cur_req[0][0]:

            rc = time + (floor - start)
            heapq.heappush(cur_req, (-rc, floor))





sol = Solution()
print(sol.elevatorRequests(8, 5, [[1, 7], [7, 3]]))