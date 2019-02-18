def __partition(A, l, r):
    pivot = A[l]
    i, j = l, r
    while i < j:
        while A[i] <= pivot:
            i += 1
            if i == r:
                break
        while A[j] >= pivot:
            j -= 1
            if j == l:
                break
        if i < j:
            A[i], A[j] = A[j], A[i]
    A[l], A[j] = A[j], A[l]
    return j    

def quick(A, l, r):
    if l < r:
        mid = __partition(A, l, r)
        quick(A, l, mid-1)
        quick(A, mid+1, r)

def main():
    arr = [3, 2, 4, 6, 9, 1, 8, 7, 5]
    quick(arr, 0, len(arr)-1)
    print(arr)

if __name__ == "__main__":
    main()