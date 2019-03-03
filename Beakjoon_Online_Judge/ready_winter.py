def solution(acorns):
    n = len(acorns)
    dp = [0]*n
    for i in range(n):
        temp = acorns[i]
        if i == 0:
            dp[i] = temp
        else:
            dp[i] = max(dp[i-1]+temp, temp)
    acorns.sort(reverse=True)
    smart = 0
    for i in range(n):
        if i != 0 and acorns[i] <= 0:
            break
        smart += acorns[i]
    return max(dp), smart



def main():
    n = int(input())
    acorns = list(map(int, input().split()))
    print(*solution(acorns))


if __name__ == '__main__':
    main()
