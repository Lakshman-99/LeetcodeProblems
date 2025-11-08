from collections import defaultdict, deque
from typing import List


class Solution:
    def findOrder2(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        map = {}

        for i in range(numCourses):
            map[i] = []

        for a, b in prerequisites:
            map[b].append(a)

        visited = set()
        pathVisited = set()
        result = []
        isEmpty = [False]
        def dfs(node):
            visited.add(node)
            pathVisited.add(node)

            for n in map[node]:
                if n not in visited:
                    dfs(n)
                if n in pathVisited:
                    isEmpty[0] = True

            result.append(node)
            pathVisited.remove(node)
            return

        for i in range(numCourses):
            if i not in visited:
                dfs(i)

        if isEmpty[0]:
            return []

        result.reverse()
        return result

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        map = defaultdict(list)
        in_degree = [0] * numCourses

        for course, prereq in prerequisites:
            map[prereq].append(course)
            in_degree[course] += 1

        q = deque([i for i in range(numCourses) if in_degree[i] == 0])
        result = []

        while q:
            node = q.popleft()
            result.append(node)

            for n in map[node]:
                in_degree[n] -= 1
                if in_degree[n] == 0:
                    q.append(n)

        return result if len(result) == numCourses else []


sol = Solution()

print(sol.findOrder(2, [[0,1]]))
print(sol.findOrder(4, [[1,0],[2,0],[3,1],[3,2]]))
print(sol.findOrder(6, [[2,3],[1,2],[0,1],[0,4],[4,5],[5,1]]))
