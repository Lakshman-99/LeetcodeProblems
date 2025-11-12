from collections import defaultdict, deque


class Solution:
    def find_order(self, words):
        graph = defaultdict(set)
        indegree = {c: 0 for word in words for c in word}

        # Step 2: Build edges by comparing adjacent words
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]

            # Invalid case: longer word before its prefix
            if len(w1) > len(w2) and w1.startswith(w2):
                return ""

            # Find first differing character
            for c1, c2 in zip(w1, w2):
                if c1 != c2:
                    if c2 not in graph[c1]:
                        graph[c1].add(c2)
                        indegree[c2] += 1
                    break  # only first difference matters

        # Step 3: Topological Sort (Kahn’s algorithm)
        q = deque([c for c in indegree if indegree[c] == 0])
        order = []

        while q:
            c = q.popleft()
            order.append(c)

            for nei in graph[c]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)

        # Step 4: Check for cycle
        if len(order) < len(indegree):
            return ""  # invalid (cycle)

        return "".join(order)


sol = Solution()

print(sol.find_order(["baa","abcd","abca","cab","cad"]))
print(sol.find_order(["caa", "aaa", "aab"]))
print(sol.find_order(["ab", "cd", "ef", "ad"]))
print(sol.find_order(["addbb", "dabcc", "cda", "bc", "a", "a"]))
print(sol.find_order(["aa", "aab", "ab", "b", "babbb"]))