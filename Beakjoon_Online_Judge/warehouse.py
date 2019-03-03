def solution(columns, max_col):
    answer = basic_h = 0
    idx, max_h = max_col
    for i in range(1, idx):
        if basic_h < columns[i]:
            basic_h = columns[i]
        answer += basic_h
    basic_h = 0
    for i in range(len(columns)-1, idx, -1):
        if basic_h < columns[i]:
            basic_h = columns[i]
        answer += basic_h
    return answer + max_h


def main():
    n = int(input())
    columns = [0]*1001
    max_col = -1, 0
    for _ in range(n):
        idx, h = map(int, input().split())
        if h > max_col[1]:
            max_col = idx, h
        columns[idx] = h
    print(solution(columns, max_col))


if __name__ == '__main__':
    main()
