def solution(points):
    total_points = [0]*3
    three_points = [0]*3
    two_points = [0]*3
    n = len(points)
    for i in range(n):
        for j in range(3):
            point = points[i][j]
            total_points[j] += point
            if point == 3:
                three_points[j] += 1
            elif point == 2:
                two_points[j] += 1
    answer = 0
    check = False

    if total_points[0] < total_points[1]:
        answer = 1
    elif total_points[0] == total_points[1]:
        if three_points[0] < three_points[1]:
            answer = 1
        elif three_points[0] == three_points[1] and \
                two_points[0] < two_points[1]:
            answer = 1
        elif two_points[0] == two_points[1]:
            check = True

    if total_points[answer] < total_points[2]:
        answer = 2
        check = False
    elif total_points[answer] == total_points[2]:
        if three_points[answer] < three_points[2]:
            answer = 2
            check = False
        elif three_points[answer] == three_points[2] and \
                two_points[answer] < two_points[2]:
            answer = 2
            check = False
        elif two_points[answer] == two_points[2]:
            check = True
    if check:
        return 0, max(total_points)

    return answer + 1, total_points[answer]


def main():
    n = int(input())
    points = []
    for _ in range(n):
        points.append(list(map(int, input().split())))
    print(*solution(points))


if __name__ == '__main__':
    main()
