def __is_prime_num(num):
    if num == 1:
        return False
    if num == 2:
        return True
    if num % 2 == 0:
        return False
    for i in range(3, int((num ** 0.5))+1, 2):
        if num % i == 0:
            return False
    return True


def solution(a, b):
    primes = []
    for i in range(a, b+1):
        if __is_prime_num(i):
            primes.append(i)
    return len(primes), primes[0] + primes[-1]


def main():
    a, b = map(int, input().split())
    print(*solution(a, b), sep="\n")


if __name__ == '__main__':
    main()
