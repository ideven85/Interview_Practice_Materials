package com.cleo.algorithms.strings;

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] w) {
        int n=w[0].length();
        int t=n*w.length; //total count of concatenated string
        List<Integer> l=new ArrayList<>();
        Map<String,Integer> hm=new HashMap<>();
        for(String q:w)
            hm.put(q,hm.getOrDefault(q,0)+1); //count vector of words
        String str="";
        int i=0;
        while((i+t-1)<s.length()){
            HashMap<String,Integer> temp=new HashMap<>(hm);
            int flag=0;
            for(int j=i;j<(i+t);j=j+n){
                str=s.substring(j,(j+n)); //take substrings of length and search it in hashmap
                if(temp.containsKey(str)){  //if substring presents in hashmap decrease it's count
                    int c=temp.get(str);
                    if(c>0)
                        temp.put(str,c-1);
                    else{
                        flag=1;
                        break;
                    }
                }
                else{ //if substring not present in hashmap terminate the loop
                    flag=1;
                    break;
                }

            }
            if(flag==0)
                l.add(i);
            i++;
        }
        return l;
    }
}
public class ConcatenatedSubStrings {

    Set<String> permutations = new HashSet<>();
    public void permute(String[] words,int low, int high){
        if(low==high){
            StringBuilder sb = new StringBuilder();
            for (String word : words) {


                sb.append(word);

            }
            System.out.println(sb);
            permutations.add(sb.toString());
        }
        for (int i = low; i <=high ; i++) {
           words= swap(words,i,low);
            permute(words,low+1,high);
           words= swap(words,i,low);

        }

         }
    public String[] swap(String[] words, int low, int high){
        String temp = words[low];
        words[low]=words[high];
        words[high]=temp;
        return words;
    }
    List<Integer> indices = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {


        permute(words,0,words.length-1);
        getAllCombinations(s);

        return indices;

    }
    public void getAllCombinations(String s){
        System.out.println(permutations);
        for (String word : permutations) {

            int length = word.length();
            for (int i = 0; i < s.length() - length + 1; i++) {
                if (s.charAt(i) == word.charAt(0)) {
                 //   System.out.println(s.substring(i, i + length));
                    if (s.substring(i, i + length).equals(word)) {
                        System.out.println(word);

                        if(!indices.contains(i))
                            indices.add(i);
                        i+=length-1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";

        String[] words = new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        //ConcatenatedSubStrings subStrings = new ConcatenatedSubStrings();
        Solution subStrings = new Solution();
        System.out.println(subStrings.findSubstring(s,words));

    }
}
