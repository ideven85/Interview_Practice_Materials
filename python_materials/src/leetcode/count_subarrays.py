def countSubarrays(arr, k):
    left, right, n = 0, 0, len(arr)
    count = 0
    running_sum = 0
    indices = set()
    while right<n and left<n:
        if arr[right]==k:
            indices.add((right,right))
            left=right
            running_sum=0
        else:
            running_sum+=arr[right]

            if running_sum==k:
                indices.add((left,right))
                if left<right:
                    running_sum-=arr[left]
                    left+=1

            #if right==n-1:
                #running_sum-=arr[right]
                #right-=1
        print(running_sum,end=' ')
        right+=1

    if right-left==2 and arr[left]+arr[right-1]==k:
        indices.add((left,right-1))
    print('\n',running_sum,left)
    print(indices)
    return len(indices)

def main():
    arr = [10, 2, -2, -20, 10]
    k = -10
    arr = [9, 4, 20, 3, 10, 5]; k = 33
    print(countSubarrays(arr,k))

if __name__ == '__main__':
    main()
