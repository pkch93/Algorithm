def __is_pattern(paper, pattern, x, y):
    m = len(pattern)
    for i in range(m):
        for j in range(m):
            if paper[y+i][x+j] != pattern[i][j]:
                return False
    return True


def solution(paper, pattern):
    answer = 0
    n, m = len(paper), len(pattern)
    k = n - m + 1
    for y in range(k):
        for x in range(k):
            if __is_pattern(paper, pattern, x, y):
                answer += 1
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
