from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        first = len(strs[0])
        common = ""
        flag = True
        v = sorted(strs)
        first = v[0]
        last = v[-1]
        for i in range(min(len(first), len(last))):
            if first[i] != last[i]:
                return common
            common += first[i]

        return common


def main():
    sol = Solution()
    strs = ["flower", "flow", "flight"]
    print(sol.longestCommonPrefix(strs))


if __name__ == "__main__":
    main()
