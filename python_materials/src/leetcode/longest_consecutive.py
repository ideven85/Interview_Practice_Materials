def longestConsecutive(arr):
    n = len(arr)
    if n==1:
        return n


    temp = sorted(arr)
    print(temp)
    curr=1;maximum = 0
    for i in range(1,n):
        if temp[i]==temp[i-1]:
            continue
        if temp[i]-temp[i-1]==1:
            curr+=1
            maximum=max(curr,maximum)
            print(maximum,temp[i],curr)
        elif temp[i]-temp[i-1]!=1:
            curr=1
    return maximum




s=[53,57,77,15,78,58,17,63,90,73,68,82,40,68,22,52,81,92,80,37,62,17,76,67,55,56,20,22,37,71,65,7,30,93,1,1,90,46,36,74,0,37,76,69,39,97,39,30,14,89,74,71,27,79,51,45,51,54,90,35,68,38,7,82,55,65,14,40,20,64,89,95,8,43,14,88,5,24,72,9,56,17,60,91,16,94,47,15,33]
print(longestConsecutive(s))






