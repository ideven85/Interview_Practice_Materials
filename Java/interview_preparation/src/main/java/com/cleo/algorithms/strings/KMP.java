package com.cleo.algorithms.strings;

public class KMP {
    public final static int d = 256;

    /** Robin Karp Algorithm
     *  pat -> pattern
     txt -> text
     q -> A prime number
     */
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println(
                            "Pattern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                        + txt.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    /**
     * KMP Algorithm
     * @param A String Input
     * @param B Pattern
     * @return Finding the last occurrence of pattern B in A
     */

    static int  findLastOccurrence(String A,String B){
        // code here
        int n = A.length(),m=B.length();
        if(n<m)
            return -1;
        int index = 0, last_index=0;
        int j = 0;
        for (int i = 0; i < A.length(); i++) {

            if((j<m)&&(A.charAt(i)==B.charAt(j))){
                if(j==m-1){
                    index=i-j+1;
                    if(last_index<=index)
                        last_index=index;
                    j=0;

                }

                j++;

            }else{
                j=0;
                //  last_index=0;
            }
        }
        return last_index==0?-1:last_index;

    }


    public static void main(String[] args) {
        System.out.println(findLastOccurrence("deve","devd"));
    }
}
