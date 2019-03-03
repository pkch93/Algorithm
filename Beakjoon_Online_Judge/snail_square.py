dx = [1, 0, -1, 0]  # 우 하 좌 상
dy = [0, 1, 0, -1]


def solution(n):
    result = [[0 for _ in range(n)] for _ in range(n)]
    d = 0
    y = 0
    x = -1
    for i in range(n ** 2):
        if __is_wall(d, n, result, x, y):
            d = (d + 1) % 4
        x = x + dx[d]
        y = y + dy[d]
        result[y][x] = i + 1
    return result


def __is_wall(d, n, result, x, y):
    nx = x + dx[d]
    ny = y + dy[d]
    if nx < 0 or nx >= n or ny < 0 or ny >= n or result[ny][nx]:
        return True
    return False


def main():
    n = int(input())
    answer = solution(n)
    for a in answer:
        print(*a)


if __name__ == '__main__':
    main()
