import sys
sys.stdin = open('inputs/coloring_input.txt')


def solution(input_list):
    answer = 0
    color_map = [[0 for _ in range(10)] for _ in range(10)]
    for elm in input_list:
        x1, y1, x2, y2, color = elm
        for y in range(y1, y2 + 1):
            for x in range(x1, x2 + 1):
                color_fill = color_map[y][x]
                if color_fill == 3:
                    continue
                if color == 1 and (color_fill == 2 or color_fill == 0):
                    color_map[y][x] += color
                elif color == 2 and (color_fill == 1 or color_fill == 0):
                    color_map[y][x] += color
    for y in range(10):
        for x in range(10):
            if color_map[y][x] == 3:
                answer += 1
    return answer


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        n = int(input())
        input_list = []
        for i in range(n):
            input_list.append(map(int, input().split()))
        print(f'#{test_case + 1} {solution(input_list)}')


if __name__ == '__main__':
    main()
