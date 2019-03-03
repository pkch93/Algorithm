def __binary_search(leafs, l, r, d):
    result = 0
    while l <= r:
        mid = (l + r) // 2
        if leafs[mid] < d:
            l = mid + 1
            result = mid + 1
        else:
            r = mid - 1
    return result


def solution(leafs):
    leafs.sort()
    n = len(leafs)
    answer = 0
    for i in range(n-2):
        first = leafs[i]
        for j in range(i+1, n-1):
            second = leafs[j]
            prev_jump = second - first
            sol = __binary_search(leafs, j, n-1, leafs[j] + prev_jump*2 + 1) - \
                __binary_search(leafs, j, n-1, leafs[j] + prev_jump)
            answer += sol
    return answer


def main():
    n = int(input())
    leafs = []
    for _ in range(n):
        leafs.append(int(input()))
    print(solution(leafs))


if __name__ == '__main__':
    main()
