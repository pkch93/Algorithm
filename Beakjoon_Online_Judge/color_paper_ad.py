
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def solution(arr):
    answer = 0
    big_paper = [[0 for _ in range(100)] for _ in range(100)]
    for x, y in arr:
        for i in range(y, y+10):
            for j in range(x, x+10):
                big_paper[i][j] = 1
    for i in range(100):
        for j in range(100):
            if big_paper[i][j] == 1:
                for k in range(4):
                    ny = dy[k] + i
                    nx = dx[k] + j
                    if 0 <= ny < 100 and 0 <= nx < 100\
                            and big_paper[ny][nx] == 0:
                        answer += 1
    return answer


def main():
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(tuple(map(int, input().split())))
    print(solution(arr))


if __name__ == '__main__':
    main()
