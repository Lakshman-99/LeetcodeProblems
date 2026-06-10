from typing import List


class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        st = []
        res = []
        buildings.sort()

        for s, e, h in buildings:
            ns = s
            if st:
                if st[-1][0] == s:
                    e = max(st[-1][1], e)
                    h = max(st[-1][2], h)
                    st.pop()
                    ns = res[-1][0]
                    res.pop()
                elif e <= st[-1][1]:
                    if h <= st[-1][2]:
                        continue
                elif s <= st[-1][1]:
                    ns = st[-1][1]
                    if h == st[-1][2]:
                        ns = res[-1][0]
                        res.pop()
                else:
                    while len(st) > 1 and st[-1][1] < st[-2][1]:
                        res.append([st[-1][1], st[-2][2]])
                        st.pop()
                    res.append([st[-1][1], 0])

            res.append([ns, h])
            st.append([s, e, h])

        while len(st) > 1 and st[-1][1] < st[-2][1]:
            res.append([st[-1][1], st[-2][2]])
            st.pop()
        res.append([st[-1][1], 0])
        return res


sol = Solution()
print(sol.getSkyline([[1,2,1],[1,2,2],[1,2,3],[2,3,1],[2,3,2],[2,3,3]]))