from typing import List

class Node:
    def __init__(self):
        self.is_leaf = False
        self.children = {}

class Trie:
    def __init__(self):
        self.root = Node()

    def get_root(self):
        return self.root

    def add_word(self, word: str) -> None:
        head = self.root
        for c in word:
            if c not in head.children:
                head.children[c] = Node()
            head = head.children[c]
        head.is_leaf = True

class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        trie = Trie()
        for word in dictionary:
            trie.add_word(word)

        n = len(s)
        cache = [0] * (n+1)

        for i in range(n-1, -1, -1):
            cache[i] = 1 + cache[i+1]
            head = trie.get_root()
            for j in range(i, n):
                if s[j] not in head.children:
                    break

                head = head.children[s[j]]
                if head.is_leaf:
                    cache[i] = min(cache[i], cache[j+1])

        return cache[0]


sol = Solution()
# print(sol.minExtraChar("ecolloycollotkvzqpdaumuqgs", ["flbri","uaaz","numy","laper","ioqyt","tkvz","ndjb","gmg","gdpbo","x","collo","vuh","qhozp","iwk","paqgn","m","mhx","jgren","qqshd","qr","qpdau","oeeuq","c","qkot","uxqvx","lhgid","vchsk","drqx","keaua","yaru","mla","shz","lby","vdxlv","xyai","lxtgl","inz","brhi","iukt","f","lbjou","vb","sz","ilkra","izwk","muqgs","gom","je"]))
# print(sol.minExtraChar("sayhelloworld", ["hello","world"]))
print(sol.minExtraChar("leetscode", ["leet","code","leetcode"]))