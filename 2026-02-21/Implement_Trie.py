import string


class Node:
    def __init__(self, val=None):
        self.val = val
        self.is_leaf = False
        self.children = {}

class Trie:

    def __init__(self):
        self.char_link = {}

    def insert(self, word: str) -> None:
        if not word:
            return

        if word[0] not in self.char_link:
            self.char_link[word[0]] = Node(word[0])

        node = self.char_link[word[0]]
        for i in range(1, len(word)):
            ch = word[i]
            if ch not in node.children:
                node.children[ch] = Node(ch)

            node = node.children[ch]

        node.is_leaf = True

    def search(self, word: str) -> bool:
        if not word:
            return True

        node = self.char_link[word[0]]
        for i in range(1, len(word)):
            ch = word[i]
            if ch not in node.children:
                return False

            node = node.children[ch]

        return node.is_leaf

    def startsWith(self, prefix: str) -> bool:
        if not prefix:
            return True

        if prefix[0] not in self.char_link:
            return False

        node = self.char_link[prefix[0]]
        for i in range(1, len(prefix)):
            ch = prefix[i]
            if ch not in node.children:
                return False

            node = node.children[ch]

        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)