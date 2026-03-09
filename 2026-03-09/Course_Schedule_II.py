from collections import defaultdict, deque
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses
        for req, pre_req in prerequisites:
            in_degree[req] += 1
            adj[pre_req].append(req)

        order = []

        def dfs(course):
            order.append(course)
            in_degree[course] -= 1
            for nei in adj[course]:
                in_degree[nei] -= 1
                if in_degree[nei] == 0:
                    dfs(nei)

        for course in range(numCourses):
            if in_degree[course] == 0:
                dfs(course)

        return order if len(order) == numCourses else []


sol = Solution()
print(sol.findOrder(4, [[1,0],[2,0],[3,1],[3,2]]))