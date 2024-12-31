package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;


public class LevenshteinDistance {


    public int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);

        return f(n,m,str1,str2,dp);
    }

    public int f(int i,int j,String word1, String word2,int dp[][] ){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1)return dp[i][j];

        if(word1.charAt(i-1)==word2.charAt(j-1))
            return dp[i][j]= f(i-1,j-1,word1,word2,dp);

        int insert = 1+f(i,j-1,word1,word2,dp);
        int delete = 1+f(i-1,j,word1,word2,dp);
        int replace = 1 + f(i-1,j-1,word1,word2,dp);

        return  dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
    // O(n*m) time,O(min(n,m)) space

    /*
def levenshteinDistance(str1, str2):
    # TIME: O(n x m)
    # SPACE: O(min(n, m)), where n = len(str1), m = len(str2)

    # do not use the entire DP matrix, only curr and prev rows
    big = str1 if len(str1) > len(str2) else str2
    sma = str2 if big == str1 else str1

    # use smaller array as column, larger is rows
    prev_row = [k for k in range(len(sma) + 1)]
    curr_row = [None for _ in range(len(sma) + 1)]

    for i in range(1, len(big) + 1):
        # set column equal to identity value
        curr_row[0] = i

        for j in range(1, len(sma) + 1):
            # treat like characters as 0-cost replacements
            repl_cost = 0 if big[i - 1] == sma[j - 1] else 1

            curr_row[j] = min(
                # remove
                prev_row[j] + 1,
                # insert
                curr_row[j - 1] + 1,
                # replace
                prev_row[j - 1] + repl_cost
            )

        # swap pointers
        prev_row, curr_row = curr_row, prev_row

    # after last iteration, prev_row was last edited curr_row
    return prev_row[-1]

     */
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int n = str1.length(),m=str2.length();
        String small = n<m?str1:str2;
        String big=n>=m?str1:str2;
        int[] evenDigits = new int[small.length()+1];
        int[] oddDigits = new int[small.length()+1];
        for (int i = 0; i < small.length()+1; i++) {
            evenDigits[i]=i;

        }
        int[] currentEdits,previousEdits;
        for (int i = 1; i < big.length()+1; i++) {

            if(i%2==1){
                currentEdits=oddDigits;
                previousEdits=evenDigits;
            }else{
                currentEdits=evenDigits;
                previousEdits=oddDigits;
            }
            currentEdits[0]=i;
            for (int j = 1; j < small.length()+1; j++) {
                if(big.charAt(i-1)==small.charAt(j-1))
                    currentEdits[j]=previousEdits[j-1];
                else{
                    currentEdits[j]=1+Math.min(previousEdits[j-1],
                            Math.min(previousEdits[j],currentEdits[j-1]));
                }
                
            }
            System.out.println(Arrays.toString(oddDigits));


        }
        return big.length()%2==0?evenDigits[small.length()]:oddDigits[small.length()];


    }



    public static void main(String[] args) {
        String word1 = "yab", word2 = "abc";
        System.out.println(new LevenshteinDistance().minDistance(word1,word2));
        LevenshteinDistance distance = new LevenshteinDistance();
        System.out.println(distance.minDistance(word1,word2));

        System.out.println(levenshteinDistance(word1,word2));
    }
}
