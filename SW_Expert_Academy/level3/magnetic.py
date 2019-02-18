import sys

sys.stdin = open('inputs/magnetic_input.txt')


def solution(input_list):
    answer = 0
    l = len(input_list)
    for x in range(l):
        flag = 0
        for y in range(l):
            if input_list[y][x] == 1:
                flag = 1
            elif flag and input_list[y][x] == 2:
                flag = 0
                answer += 1
    return answer


def main():
    for test_case in range(10):
        input()
        input_list = []
        for _ in range(100):
            input_list.append(list(map(int, input().split())))
        print(f'#{test_case+1} {solution(input_list)}')


if __name__ == '__main__':
    main()
