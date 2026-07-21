from collections import defaultdict


class Solution:
    def smallestSubsequence(self, s: str) -> str:
        last = {c: i for i, c in enumerate(s)}
        st = []
        seen = set()

        for i, c in enumerate(s):
            if c in seen:
                continue

            while st and st[-1] > c and last[st[-1]] > i:
                seen.discard(st.pop())

            st.append(c)
            seen.add(c)

        return "".join(st)


    def smallestSubsequence2(self, s: str) -> str:
        mc = min(s)
        ind = s.find(mc)

        def find(l, r, seen):
            ans = []

            for i in range(l, r):
                if s[i] in seen:
                    continue

                seen.add(s[i])
                ans.append(s[i])

            return ans

        s1 = set()
        x1 = find(ind, len(s), s1)
        y1 = find(0, ind, s1)
        p1 = "".join(y1 + x1)

        s2 = set()
        x2 = find(0, ind, s2)
        y2 = find(ind, len(s), s2)
        p2 = "".join(x2 + y2)

        return min(p1, p2)


sol = Solution()
print(sol.smallestSubsequence("cbacdcbca"))