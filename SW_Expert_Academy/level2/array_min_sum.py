import sys

sys.stdin = open('inputs/array_min_sum_input.txt')

check = [False] * 10


def solution(arr, k, n, total):
    global min_sum
    if total > min_sum:
        return
    if k == n:
        if total < min_sum:
            min_sum = total
    else:
        for i in range(n):
            if not check[i]:
                check[i] = True
                solution(arr, k + 1, n, total + arr[k][i])
                check[i] = False


def main():
    global min_sum
    test_cases = int(input())
    for test_case in range(test_cases):
        arr = []
        n = int(input())
        for _ in range(n):
            arr.append(list(map(int, input().split())))
        min_sum = float('inf')
        total = 0
        solution(arr, 0, n, total)
        print(f'#{test_case + 1} {min_sum}')


if __name__ == '__main__':
    main()
