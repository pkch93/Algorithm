def solution(belt, kind, k, c):
    n = len(belt)
    check = 0
    for i in range(n - k, n):
        if kind[belt[i]] == 0:
            check += 1
        kind[belt[i]] += 1
    max_sushi = 0
    for i in range(n):
        if kind[belt[i]] == 0:
            check += 1
        kind[belt[i]] += 1
        del_sushi = (n + i - k) % n
        if kind[belt[del_sushi]] == 1:
            check -= 1
        kind[belt[del_sushi]] -= 1
        max_sushi = max(max_sushi, check + (kind[c] == 0))
    return max_sushi


def main():
    n, d, k, c = map(int, input().split())
    belt = [0] * 30001
    kind = [0] * 3001
    for _ in range(n):
        belt.append(int(input()))
    print(solution(belt, kind, k, c))


if __name__ == '__main__':
    main()
