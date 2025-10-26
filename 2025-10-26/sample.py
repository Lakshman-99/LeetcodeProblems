from typing import List

# Write any import statements here
def getMaxAdditionalDinersCount(N: int, k: int, M: int, S: List[int]) -> int:
    # Write your code here
    S.sort()
    ans = 0
    for ind, val in enumerate(S):
        lower, upper = 0, N
        if ind == 0:
            lower = 0
        else:
            lower = S[ind - 1]

        if ind == M - 1:
            upper = N+1
        else:
            upper = S[ind + 1]

        temp = val
        while temp - k - 1 > lower:
            ans += 1
            temp -= k - 1

        temp = val
        while temp + k + 1 < upper:
            ans += 1
            temp += k + 1

    return ans


getMaxAdditionalDinersCount(10, 1, 2, [2,6])