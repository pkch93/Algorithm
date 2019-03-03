def solution(arr, y, x):
    answer = [[arr[i][j] if j == 0 else 0
               for j in range(x)] for i in range(y)]
    for i in range(y):
        for j in range(1, x):
            if arr[i][j]:
                answer[i][j] += answer[i][j-1] + 1
    return answer


def main():
    y, x = map(int, input().split())
    arr = []
    for _ in range(y):
        arr.append(list(map(int, input().split())))
    answer = solution(arr, y, x)
    for i in range(y):
        print(*answer[i])


if __name__ == '__main__':
    main()
