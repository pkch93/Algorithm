angle_list = [90, 180, 270, 360]


def solution(arr, angles):
    n = len(arr)
    result = [[0 for _ in range(n)] for _ in range(n)]
    for angle in angles:
        if angle not in angle_list:
            continue
        spin_num = angle // 90
        for _ in range(spin_num):
            for i in range(n):
                for j in range(n):
                    result[i][j] = arr[n-j-1][i]
            arr = [result[i][:] for i in range(n)]
        for i in range(n):
            print(*result[i])


def main():
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))
    angles = []
    while True:
        k = int(input())
        if k:
            angles.append(k)
        else:
            break
    solution(arr, angles)


if __name__ == '__main__':
    main()
