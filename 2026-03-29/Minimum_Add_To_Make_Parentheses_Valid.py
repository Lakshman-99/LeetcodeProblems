class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        st = []

        for ch in s:
            if st and ch == ')' and st[-1] == '(':
                st.pop()
            else:
                st.append(ch)

        return len(st)


sol = Solution()
print(sol.minAddToMakeValid("((("))