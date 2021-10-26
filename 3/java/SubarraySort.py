def getSubarraySort(arr):
    n = len(arr) 
    if(n == 1):
        return [-1, -1]

    minOutOfOrder = float("inf")
    maxOutOfOrder = float("-inf")

    for i in range(n):
        isOutOfOrder = False

        if(i == 0):
            if(arr[i] > arr[i+1]): #ex [ 10, 2, 3, 4 ] <- 10 galat order
                isOutOfOrder = True
        elif(i == n-1):
            if(arr[i-1] > arr[i]): #ex [1, 2, 4, 3] <- 5 galat order
                isOutOfOrder = True
        else:
            if(arr[i-1] > arr[i] or arr[i] > arr[i+1]): #[1 10 2] <-10 galt order 
                isOutOfOrder = True

        if(isOutOfOrder):
            minOutOfOrder = min(minOutOfOrder, arr[i])
            maxOutOfOrder = max(maxOutOfOrder, arr[i]) 

    if(minOutOfOrder == float("inf")):
        return [-1,-1]

    res = []
    for i in range(0,n):
        if(minOutOfOrder < arr[i]):
            res.append(i)
            break

    for i in range(n-1, 0, -1):
        if(maxOutOfOrder > arr[i]):
            res.append(i)
            break
    return res

print(getSubarraySort(list(map(int, input().split(" ")))))
