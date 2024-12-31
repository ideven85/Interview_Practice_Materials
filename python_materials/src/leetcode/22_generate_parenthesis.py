from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        out = []
        if n < 1:
            return []

        def dfs(curr, left, right):
            if len(curr) == 2 * n:
                out.append(curr)
                return
            if left < n:

                dfs(curr + "(", left + 1, right)
            if left > right:

                dfs(curr + ")", left, right + 1)

        dfs("", 0, 0)
        return out


def main():
    sol = Solution()
    print(sol.generateParenthesis(5))


if __name__ == "__main__":
    main()
