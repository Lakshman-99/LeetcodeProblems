from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        if not (4 <= len(s) <= 12):
            return []

        n = len(s)
        res = []

        def backtrack(seg_start, segments):
            if len(segments) == 4:
                if seg_start == n:
                    res.append(".".join(segments))
                return

            for length in range(1, 4):
                if seg_start + length > n:
                    break

                seg_str = s[seg_start : seg_start + length]
                seg_int = int(seg_str)

                if seg_int > 255 or (length > 1 and seg_str[0] == '0'):
                    break

                segments.append(seg_str)
                backtrack(seg_start + length, segments)
                segments.pop()

        backtrack(0, [])
        return res

    def restoreIpAddresses2(self, s: str) -> List[str]:
        if not (4 <= len(s) <= 12):
            return []

        n = len(s)
        res = []

        def backtrack(i, dots):
            if len(dots) == 3:
                last_num = int(s[dots[-1]:])
                if (n - dots[-1] > 1 and s[dots[-1]] == '0') or not (0 <= last_num <= 255):
                    return

                dots = [0] + dots + [n]
                ip = []
                for idx in range(1, 5):
                    ip.append(s[dots[idx-1]:dots[idx]])

                res.append(".".join(ip))
                return

            for j in range(i+1, min(i+4, n)):
                num = int(s[i:j])
                if (s[i] == '0' and j-i > 1) or not (0 <= num <= 255):
                    break

                dots.append(j)
                backtrack(j, dots)
                dots.pop()

        backtrack(0, [])
        return res


sol = Solution()
print(sol.restoreIpAddresses("172162541"))