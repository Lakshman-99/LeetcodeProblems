from typing import List


class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        paths = path.split("/")

        for part in paths:
            if part == "" or part == ".":
                continue

            if part == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(part)

        return "/" + "/".join(stack)


sol = Solution()
print(sol.simplifyPath("/..hidden"))
print(sol.simplifyPath("/a/../../b/../c//.//"))
print(sol.simplifyPath("/.../a/../b/c/../d/./"))