import sys
sys.stdin = open("inputs/disitsum_input.txt")
def solution(x):
    while True:
        temp = 0
        while x // 10 > 0:
            temp += x % 10
            x //= 10
        temp += x
        if temp // 10 == 0:
            return temp
        x = temp

def main():
    n = int(input())
    for test_case in range(n):
        x = int(input())
        print(f"#{test_case + 1} {solution(x)}")

if __name__ == "__main__":
    main()