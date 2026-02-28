import math
from collections import defaultdict
from functools import cache
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
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for w in words:
            trie.add_word(w)

        ans = []
        n, m = len(board), len(board[0])

        def dfs(r, c, root, word):
            nonlocal n, m
            if root.is_leaf:
                ans.append(word)
                root.is_leaf = False

            tmp = board[r][c]
            board[r][c] = "#"
            for dr, dc in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                new_r, new_c = r + dr, c + dc
                if 0 <= new_r < n and 0 <= new_c < m and board[new_r][new_c] != "#":
                    next_char = board[new_r][new_c]
                    if next_char in root.children:
                        dfs(new_r, new_c, root.children[next_char], word + next_char)

            board[r][c] = tmp

        node = trie.get_root()
        for i in range(n):
            for j in range(m):
                if board[i][j] in node.children:
                    dfs(i, j, node.children[board[i][j]], board[i][j])

        return ans


sol = Solution()
print(sol.findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], ["hklf", "hf"]))