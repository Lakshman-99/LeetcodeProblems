class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: list[list[int]]) -> list[int]:
        in_degree = [0] * n
        for a, b in edges:
            in_degree[b] += 1

        return [i for i in range(n) if not in_degree[i]]


sol = Solution()
print(sol.findSmallestSetOfVertices(6, [[0,1],[0,2],[2,5],[3,4],[4,2]]))