import sys

sys.stdin = open('inputs/paste_paper_input.txt')


def solution(n):
    k = n // 10
    dp = [1, 3]
    for i in range(2, k):
        if i % 2 == 1:
            dp.append((dp[i-1])*2 + 1)
        else:
            dp.append((dp[i-1])*2 - 1)
    return dp[k-1]


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        n = int(input())
        print(f'#{test_case+1} {solution(n)}')


if __name__ == '__main__':
    main()