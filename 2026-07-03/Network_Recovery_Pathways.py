from typing import List


class Solution:
    def findMaxPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        n = len(online)
        adj = [[] for _ in range()]


sol = Solution()
print(sol.findMaxPathScore([[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]], [True,True,True,False,True], 12))