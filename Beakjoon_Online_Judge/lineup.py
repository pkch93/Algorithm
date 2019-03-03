def solution(numbers):
    lineup = []
    n = len(numbers)
    k = 0
    for i in range(n):
        lineup.insert(k-numbers[i], i+1)
        k += 1
    return lineup

def main():
    n = int(input())
    numbers = list(map(int, input().split()))
    print(*solution(numbers))


if __name__ == '__main__':
    main()
