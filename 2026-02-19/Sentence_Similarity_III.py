

class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        if len(sentence2) > len(sentence1):
            sentence1, sentence2 = sentence2, sentence1

        words1 = sentence1.split(" ")
        words2 = sentence2.split(" ")

        L, R = 0, len(words1)-1
        l, r = 0, len(words2)-1
        while l <= r:
            if words2[l] == words1[L]:
                l, L = l+1, L+1
            elif words2[r] == words1[R]:
                r, R = r-1, R-1
            else:
                return False

        return True


sol = Solution()
print(sol.areSentencesSimilar("A B C D B B", "A B B"))
print(sol.areSentencesSimilar("BOLLY", "holly BOLLY polly"))