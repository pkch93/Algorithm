import sys
sys.stdin = open("inputs/view_input.txt")

def solution(input_list):
    n, answer = len(input_list), 0
    for i in range(2, n - 2):
        temp = input_list[i]
        m = temp - max(input_list[i - 1], input_list[i - 2], input_list[i + 1], input_list[i + 2])
        m = 0 if m < 0 else m
        answer += m
    return answer

def main():
    for i in range(10):
        n = int(input())
        input_list = list(map(int, input().split()))
        print(f"#{i + 1} {solution(input_list)}")

if __name__ == "__main__":
    main()