
def solution(arr):
    answer = 0
    big_paper = [[0 for _ in range(100)] for _ in range(100)]
    for x, y in arr:
        for i in range(y, y+10):
            for j in range(x, x+10):
                big_paper[i][j] = 1
    for i in range(100):
        answer += big_paper[i].count(1)
    return answer


def main():
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(tuple(map(int, input().split())))
    print(solution(arr))


if __name__ == '__main__':
    main()
