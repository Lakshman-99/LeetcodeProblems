from typing import List


class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_map = {}
        for account in accounts:
            user_name = account[0]
            for i in range(1, len(account)):
                email_map[account[i]] = user_name



sol = Solution()
print(sol.accountsMerge([["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]))