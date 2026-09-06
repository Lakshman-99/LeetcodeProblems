from typing import List


class Solution:
    def maximumBooks(self, books: List[int]) -> int:
        n = len(books)
        ans = st_sum = 0
        st = []

        for i in range(n):
            cur = books[i]
            j = -1
            while len(st) >= abs(j) and st[j] >= cur:
                val = st[j]
                st[j] = max(0, cur - 1)
                st_sum -= (val - st[j])
                cur = st[j]
                j -= 1

            st_sum += books[i]
            ans = max(ans, st_sum)
            st.append(books[i])

        return ans


sol = Solution()
print(sol.maximumBooks([12,2,11,7,13,18,11,6]))