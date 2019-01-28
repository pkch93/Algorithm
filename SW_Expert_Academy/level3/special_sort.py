import sys

sys.stdin = open('inputs/special_sort_input.txt')

def solution(input_list):
    n = len(input_list)
    for i in range(0, n-2, 2):
        max_num = i
        min_num = i
        for j in range(i, n):
            if input_list[max_num] < input_list[j]:
                max_num = j
        input_list[i], input_list[max_num] = input_list[max_num], input_list[i]
        for j in range(i, n):
            if input_list[min_num] > input_list[j]:
                min_num = j
        input_list[i + 1], input_list[min_num] = input_list[min_num], input_list[i + 1]
    else:
        if input_list[-1] > input_list[-2]:
            input_list[-1], input_list[-2] = input_list[-2], input_list[-1]
    return input_list
def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        input()
        input_list = list(map(int, input().split()))
        print(f'#{test_case + 1}', *solution(input_list)[0:10], sep=' ')

if __name__ == '__main__':
    main()