from functools import lru_cache
from typing import List


class Solution:

    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """
            You have planned some train traveling one year in advance.
         The days of the year in which you will travel are given as an integer array days.
        Each day is an integer from 1 to 365.

        Train tickets are sold in three different ways:

        a 1-day pass is sold for costs[0] dollars,
        a 7-day pass is sold for costs[1] dollars, and
        a 30-day pass is sold for costs[2] dollars.
        The passes allow that many days of consecutive travel.

        For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
        Return the minimum number of dollars you need to travel every day in the given list of days.
        """
        last_day = days[-1]
        days_set = set(days)
        @lru_cache(maxsize=None)
        def dp(i):

            if i<=0:
                return 0
            if i not in days_set:
                return dp(i-1)
            return min(
                dp(i-1)+costs[0],
                dp(i-7)+costs[1],
                dp(i-30)+costs[2]
            )
        return dp(last_day)


def main():
    days = [1, 4, 6, 7, 8, 20]
    costs = [2, 7, 15]
    """
    Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.
    """
    sol=Solution()
    print(sol.mincostTickets(days,costs))
if __name__ == '__main__':
    main()
