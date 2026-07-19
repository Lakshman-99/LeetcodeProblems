from collections import Counter
from typing import List


class Solution:
    def transformStr(self, s: str, strs: List[str]) -> List[bool]:
        n = len(s)
        sc = Counter(s)
        sz, so = sc['0'], sc['1']

        ans = []
        for str in strs:
            strc = Counter(str)
            z, o, q = strc['0'], strc['1'], strc['?']

            if z > sz or o > so:
                ans.append(False)
                continue

            rem = 0
            needed_o = so - o
            for i in range(n-1, -1, -1):
                sch = s[i]
                qch = str[i]

                if qch == '?':
                    if needed_o > 0:
                        qch = '1'
                        needed_o -= 1
                    else:
                        qch = '0'

                if qch == '0' and sch != qch:
                    if rem <= 0:
                        ans.append(False)
                        break
                    rem -= 1
                elif qch == '1' and sch != qch:
                    rem += 1
            else:
                ans.append(True)

        return ans




sol = Solution()
print(sol.transformStr("101",["1?1","0?1","0?0"]))
print(sol.transformStr("1100",["0011","11?1","1?1?"]))