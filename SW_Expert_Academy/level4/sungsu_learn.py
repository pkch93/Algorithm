import sys
sys.stdin = open("inputs/sungsulearn_input.txt")
def solution(K, studies):
    n = len(studies)
    targets = sorted(studies)[n-K:]
    answer = 0
    for t in targets:
        answer = (answer + t) / 2
    return answer

def main():
    T = int(input())
    for test_case in range(T):
        N, K = map(int, input().split())
        studies = list(map(int, input().split()))
        print(f"#{test_case + 1} {solution(K, studies)}")

if __name__ == '__main__':
    main()