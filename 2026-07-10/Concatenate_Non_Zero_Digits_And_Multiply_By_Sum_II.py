from typing import List


class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        MOD = 10 ** 9 + 7
        pref_sum = [0] * (n + 1)
        pref_num = [0] * (n + 1)
        pref_cnt = [0] * (n + 1)
        p10s = [1] * (n + 1)

        for i in range(n):
            p10s[i+1] = (p10s[i] * 10) % MOD

        for i in range(n):
            d = int(s[i])
            if d:
                pref_sum[i+1] = (pref_sum[i] + d) % MOD
                pref_num[i+1] = (pref_num[i] * 10 + d) % MOD
                pref_cnt[i+1] = pref_cnt[i] + 1
            else:
                pref_sum[i + 1] = pref_sum[i]
                pref_num[i + 1] = pref_num[i]
                pref_cnt[i + 1] = pref_cnt[i]

        res = []
        for s, e in queries:
            ps = (pref_sum[e+1] - pref_sum[s]) % MOD
            non_zeros = pref_cnt[e+1] - pref_cnt[s]
            num = 0
            if non_zeros:
                num = (pref_num[e+1] - pref_num[s] * p10s[non_zeros]) % MOD
                num = (num * ps) % MOD

            res.append(num)

        return res


sol = Solution()
print(sol.sumAndMultiply("035614", [[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[1,1],[1,2],[1,3],[1,4],[1,5],[2,2],[2,3],[2,4],[2,5],[3,3],[3,4],[3,5],[4,4],[4,5],[5,5]]))