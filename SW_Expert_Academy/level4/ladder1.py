import sys

sys.stdin = open('inputs/ladder1_input.txt')


def solution(input_list, x, y):
    while True:
        input_list[y][x] = 0
        if y == 0:
            return x
        if x-1 >= 0 and input_list[y][x-1] == 1:
            x -= 1
        elif x+1 < 100 and input_list[y][x+1] == 1:
            x += 1
        else:
            y -= 1


def main():
    for test_case in range(10):
        input()
        input_list = []
        for _ in range(100):
            input_list.append(list(map(int, input().split())))

        for j in range(len(input_list[99])):
            if input_list[99][j] == 2:
                y, x = 99, j
                break
        print(f"#{test_case + 1} {solution(input_list, x, y)}")


if __name__ == '__main__':
    main()
