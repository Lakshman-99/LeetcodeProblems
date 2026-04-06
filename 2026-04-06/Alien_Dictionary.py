from collections import defaultdict, deque
from typing import List


class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = defaultdict(set)
        in_degree = {c: 0 for word in words for c in word}

        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i+1]
            if len(w1) > len(w2) and w1.startswith(w2):
                return ""

            for c1, c2 in zip(w1, w2):
                if c1 != c2:
                    if c2 not in adj[c1]:
                        adj[c1].add(c2)
                        in_degree[c2] += 1
                    break

        q = deque([c for c in in_degree if in_degree[c] == 0])
        res = []

        while q:
            c = q.popleft()
            res.append(c)
            for nei in adj[c]:
                in_degree[nei] -= 1
                if in_degree[nei] == 0:
                    q.append(nei)

        if len(res) != len(in_degree):
            return ""

        return "".join(res)


sol = Solution()
print(sol.foreignDictionary(["hrn","hrf","er","enn","rfnn"]))