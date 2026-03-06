from typing import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        is_trusting = [False] * (n+1)
        trust_freq = [0] * (n+1)

        for a, b in trust:
            is_trusting[a] = True
            trust_freq[b] += 1

        for i in range(n+1):
            if not is_trusting[i] and trust_freq[i] == n - 1:
                return i

        return -1


sol = Solution()
print(sol.findJudge(3, [[1,3],[2,3]]))