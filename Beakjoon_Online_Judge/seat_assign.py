dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def solution(x, y, k):
    seat_map = [[0 for _ in range(x)] for _ in range(y)]
    cnt = 0
    i = j = 0
    flag = 0
    while cnt <= x*y:
        cnt += 1
        if cnt == k:
            return j+1, i+1
        seat_map[i][j] = cnt
        if flag % 2 == 0:
            i += dy[flag]
            if i + dy[flag] < 0 or i + dy[flag] >= y \
                    or seat_map[i + dy[flag]][j]:
                flag = (flag + 1) % 4
        elif flag % 2 == 1:
            j += dx[flag]
            if j + dx[flag] < 0 or j + dx[flag] >= x or \
                    seat_map[i][j + dx[flag]]:
                flag = (flag + 1) % 4
    return 0


def main():
    x, y = map(int, input().split())
    k = int(input())
    answer = solution(x, y, k)
    if answer:
        print(*answer)
    else:
        print(0)


if __name__ == '__main__':
    main()
