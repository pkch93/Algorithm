import sys

sys.stdin = open('inputs/bs_input.txt')


def solution(P, key):
    count = 0
    start = 1
    end = P
    while start <= end:
        count += 1
        mid = (start + end) // 2
        if mid < key:
            start = mid
        elif mid > key:
            end = mid
        else:
            return count
    return 10000


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        P, A, B = map(int, input().split())
        count_A = solution(P, A)
        count_B = solution(P, B)
        if count_A < count_B:
            winner = 'A'
        elif count_A > count_B:
            winner = 'B'
        else:
            winner = 0
        print(f'#{test_case + 1} {winner}')


if __name__ == '__main__':
    main()
