def __spin(pattern):
    p = len(pattern)
    rotated_pattern = [[0 for _ in range(p)] for _ in range(p)]
    for i in range(p):
        for j in range(p):
            rotated_pattern[i][j] = pattern[j][p-i-1]
    return rotated_pattern


def __is_pattern(paper, pattern, x, y):
    m = len(pattern)
    temp = [pattern[i][:] for i in range(m)]
    result = 0
    for _ in range(4):
        flag = True
        for i in range(m):
            if not flag:
                break
            for j in range(m):
                if paper[y+i][x+j] != temp[i][j]:
                    flag = False
        if flag:
            result += 1
        temp = __spin(temp)
    return result


def solution(paper, pattern):
    answer = 0
    n, m = len(paper), len(pattern)
    k = n - m + 1
    for y in range(k):
        for x in range(k):
            answer += __is_pattern(paper, pattern, x, y)
    return answer


def main():
    n = int(input())
    paper = []
    for _ in range(n):
        paper.append(list(map(int, input())))
    m = int(input())
    pattern = []
    for _ in range(m):
        pattern.append(list(map(int, input())))
    print(solution(paper, pattern))


if __name__ == '__main__':
    main()
