class Solution:
    def get_fact(self, n):
        fact = 1
        for i in range(1, n + 1):
            fact *= i
        return fact

    def get_perm(self, n, k):
        fact = self.get_fact(n-1)
        k -= 1
        ans = []
        numbers = list(range(n))

        while numbers:
            i = int(k // fact)
            ans.append(str(numbers[i]))
            numbers.pop(i)
            if not numbers:
                break

            k %= fact
            fact //= len(numbers)

        return "".join(ans)

    def smallestPalindrome(self, s: str, k: int) -> str:
        n = len(s)
        h = n // 2
        mid = s[h] if n % 2 == 1 else ""

        proc = "".join(sorted(s[:h]))
        m = len(proc)
        fact = self.get_fact(m)

        if fact < k or (not proc and mid and k > 1):
            return ""

        perm = self.get_perm(m, k)
        proc = "".join(proc[int(i)] for i in perm)

        return proc + mid + proc[::-1]


sol = Solution()
print(sol.smallestPalindrome("xxnfnxx", 3))