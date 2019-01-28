import sys

sys.stdin = open('inputs/sum_input.txt')


def find_max(*nums):
    max_num = nums[0]
    for i in range(1, len(nums)):
        target = nums[i]
        if max_num < target:
            max_num = target
    return max_num


def solution(input_list):
    max_sum = -float('inf')
    n = len(input_list)
    a = b = 0
    for i in range(n):
        v = h = 0
        a += input_list[i][i]
        b += input_list[i][-i-1]
        for j in range(n):
            v += input_list[j][i]
            h += input_list[i][j]
        max_sum = find_max(max_sum, v, h)
    return find_max(max_sum, a, b)


def main():
    for test_case in range(10):
        input_list = []
        int(input())
        for i in range(100):
            input_list.append(list(map(int, input().split())))
        print(f"#{test_case + 1} {solution(input_list)}")


if __name__ == '__main__':
    main()
