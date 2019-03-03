dx = [1, 0, -1, 0] # 우 하 좌 상
dy = [0, 1, 0, -1]


def solution(n, items, moves):
    board = [[0]*n for _ in range(n)]
    y = x = 0
    board[y][x] = 1
    s_len = 1


def main():
    n = int(input())
    k = int(input())
    items = []
    for _ in range(k):
        items.append(tuple(map(int, input().split())))
    l = int(input())
    moves = []
    for _ in range(l):
        x, c = map(int, input().split())
        moves.append((int(x), c))
    print(solution(n, items, moves))


if __name__ == '__main__':
    main()
