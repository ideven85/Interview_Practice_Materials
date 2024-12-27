import time
from collections import defaultdict, deque
from typing import List


#fixme
class Solution:
    def levenshteinDistance(self,str1, str2):
        # Write your code here.
        m = len(str1)
        n = len(str2)
        L = [[i for i in range(n + 1)] for j in range(m + 1)]
        for i in range(1, m + 1):
            L[i][0] = L[i - 1][0] + 1
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if str1[i - 1] == str2[j - 1]:
                    L[i][j] = L[i - 1][j - 1]
                elif j < n and i < m and str1[i - 1] == str2[j] and str1[i] == str2[j - 1]:
                    L[i][j] = L[i - 1][j - 1]
                else:
                    L[i][j] = 1 + min(L[i - 1][j], L[i - 1][j - 1], L[i][j - 1])

        return L[-1][-1]
    def ladderLength(self,begin_word: str, end_word: str, word_list: List[str]) -> int:
            """
                   A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
                   sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

           Every adjacent pair of words differs by a single letter.
           Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
           sk == endWord
           wordList size-> 5*10^4 words
           Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

            Do breadth first search, agenda
            Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
               """
            def get_neighbours(curr_word):
                for word in word_list:

                    if self.levenshteinDistance(curr_word,word)==1:
                        graph[curr_word].append(word)
                        graph[word].append(curr_word)

                #print(graph)
                return graph[curr_word]


            if end_word not in word_list:
                return 0


            graph = defaultdict(list)

            begin_distance = 0 if begin_word in word_list else 1

            visited = set()
            agenda = deque()
            agenda.append((begin_word,1))
            visited.add(begin_word)
            min_distance = 123445678

            while len(agenda)>=1:
                # = agenda.popleft()

                current_word,current_distance = agenda.popleft()
                neighbors = get_neighbours(current_word)
                if not neighbors:
                    return 0
                #print(neighbors)
                #input()
                for neighbour in neighbors:
                    if neighbour in visited:
                        continue
                    if neighbour == end_word:
                       return current_distance+1
                    visited.add(neighbour)
                    agenda.append((neighbour, current_distance + 1))
            return 0






def main():
    begin_word = "cet"
    end_word = "ism"
    word_list =["kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"]
    s = time.perf_counter_ns()
    b="hit"
    e="cog"
    words=["hot","dot","dog","lot","log","cog"]
    print(Solution().ladderLength(begin_word,end_word,word_list))
    end = time.perf_counter_ns()
    print(end-s)
    print(Solution().ladderLength(b,e,words))

if __name__ == '__main__':
    main()









