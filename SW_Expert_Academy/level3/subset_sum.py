import sys

sys.stdin = open('inputs/subset_input.txt')


def solution(N, K):
    answer = 0
    A = [i + 1 for i in range(12)]
    n = len(A)
    for i in range(1 << n):
        num_sum = 0
        count = 0
        for j in range(n):
            if i & (1 << j):
                num_sum += A[j]
                count += 1
        if num_sum == K and count == N:
            answer += 1
    return answer


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        N, K = map(int, input().split())
        print(f'#{test_case + 1} {solution(N, K)}')


if __name__ == '__main__':
    main()
