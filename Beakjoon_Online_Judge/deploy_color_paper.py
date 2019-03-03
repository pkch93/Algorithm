
def solution(arr):
    big_paper = [[0 for _ in range(100)] for _ in range(100)]
    y, x, c, r = arr[0]
    for i in range(y-1, y+r+1):
        for j in range(x-1, x+c+1):
            if i == y-1 or i == y+r or j == x-1 or j == x+c:
                big_paper[i][j] = 2
            else:
                big_paper[i][j] = 1
    y, x, c, r = arr[1]
    one, two = 0, 0
    for i in range(y, y + r):
        for j in range(x, x + c):
            if big_paper[i][j] == 1:
                one += 1
            elif big_paper[i][j] == 2:
                two += 1
    if not one and two == 1:
        return 1
    elif not one and two > 1:
        return 2
    elif one:
        return 3
    else:
        return 4
# type 1은 1의 갯수 0개, 2의 갯수 1개
# type 2는 1의 갯수 0개, 2의 갯수 2개 이상
# type 3은 1의 갯수 1개 이상
# 그 외 type 4


def main():
    arr = []
    for _ in range(2):
        arr.append(tuple(map(int, input().split())))
    print(solution(arr))


if __name__ == '__main__':
    main()
