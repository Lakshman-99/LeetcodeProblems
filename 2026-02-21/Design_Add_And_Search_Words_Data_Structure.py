class Node:
    def __init__(self):
        self.is_leaf = False
        self.children = {}

class WordDictionary:

    def __init__(self):
        self.root = Node()

    def addWord(self, word: str) -> None:
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = Node()

            cur = cur.children[ch]

        cur.is_leaf = True

    def _dfs(self, node, word, idx):
        if idx == len(word):
            return node.is_leaf

        ch = word[idx]
        if ch == '.':
            for child in node.children.values():
                if self._dfs(child, word, idx+1):
                    return True

        if ch not in node.children:
            return False

        return self._dfs(node.children[ch], word, idx+1)

    def search(self, word: str) -> bool:
        return self._dfs(self.root, word, 0)


# Your WordDictionary object will be instantiated and called as such:
obj = WordDictionary()
word = "bad"
obj.addWord(word)
param_2 = obj.search(".ad")
print(param_2)