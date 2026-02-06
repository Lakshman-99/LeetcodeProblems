

def guess(g):
    p = 2
    if g > p:
        return -1
    if g < p:
        return 1
    return 0

class Solution:
    def guessNumber(self, n: int) -> int:
        l, r = 1, n
        while l <= r:
            mid = l + (r - l) // 2
            g = guess(mid)
            if g == 0:
                return mid
            elif g == 1:
                l = mid+1
            else:
                r = mid-1

        return l



sol = Solution()
print(sol.guessNumber(2))