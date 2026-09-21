from collections import deque


class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: list[str]) -> int:
        bank = set(bank)
        if endGene not in bank:
            return -1

        GENES = ('A', 'C', 'G', 'T')
        q = deque([(startGene, 0)])
        while q:
            seq, step = q.popleft()
            if seq == endGene:
                return step

            for i in range(8):
                for ch in GENES:
                    new_seq = seq[:i] + ch + seq[i+1:]
                    if new_seq in bank:
                        bank.remove(new_seq)
                        q.append((new_seq, step + 1))

        return -1


sol = Solution()
print(sol.minMutation("AACCGGTT", "AAACGGTA", ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"]))