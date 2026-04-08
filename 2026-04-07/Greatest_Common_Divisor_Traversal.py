from typing import List


class DSU:
    def __init__(self, n):
        self.n = n
        self.p = list(range(n + 1))
        self.rank = [1] * (n + 1)

    def find(self, node):
        while node != self.p[node]:
            self.p[node] = self.p[self.p[node]]
            node = self.p[node]
        return node

    def union(self, v1, v2):
        p1, p2 = self.find(v1), self.find(v2)
        if p1 == p2:
            return False

        self.n -= 1
        if self.rank[p1] < self.rank[p2]:
            p1, p2 = p2, p1

        self.p[p2] = p1
        self.rank[p1] += self.rank[p2]

        return True

    def is_connected(self):
        return self.n == 1


class Solution:
    def canTraverseAllPairs(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1:
            return True

        dsu = DSU(n)
        prime_to_idx = {}

        for i, num in enumerate(nums):
            if num == 1:
                return False

            f = 2
            while f * f <= num:
                if num % f == 0:
                    if f in prime_to_idx:
                        dsu.union(i, prime_to_idx[f])
                    else:
                        prime_to_idx[f] = i

                    while num % f == 0:
                        num //= f
                f += 1

            if num > 1:
                if num in prime_to_idx:
                    dsu.union(i, prime_to_idx[num])
                else:
                    prime_to_idx[num] = i

        return dsu.is_connected()


sol = Solution()
print(sol.canTraverseAllPairs([2,3,6]))