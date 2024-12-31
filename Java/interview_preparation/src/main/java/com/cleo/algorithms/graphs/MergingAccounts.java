package com.cleo.algorithms.graphs;

import java.util.List;

public class MergingAccounts {
    //Example 1:
    //
    //Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],
    // ["John","johnsmith@mail.com","john00@mail.com"],=> Merge these two emails under name John
    // ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]] => This does not have a common email
    //Cannot use name as key for Map... what the hell now
    //Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
    // ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
    //Explanation:
    //The first and second John's are the same person as they have the common email "johnsmith@mail.com".
    //The third John and Mary are different people as none of their email addresses are used by other accounts.
    //We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
    //['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        return null;
    }
}
