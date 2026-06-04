class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        ans = 0

        for num in range(max(100, num1), num2+1):
            s_num = str(num)

            for i in range(1, len(s_num)-1):
                if s_num[i-1] < s_num[i] > s_num[i+1] or s_num[i-1] > s_num[i] < s_num[i+1]:
                    ans += 1

        return ans


sol = Solution()
print(sol.totalWaviness(120, 130))