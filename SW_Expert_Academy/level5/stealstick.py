import sys

sys.stdin = open('inputs/stealstick_input.txt')


def print_answer(number, answer):
    str = ""
    for t in answer:
        str += f"{t[0]} {t[1]} "
    print(f"#{number} {str.strip()}")


def solution(screws):
    n = len(screws)
    answer = []
    max_cnt = -float('inf')
    for i in range(n):
        count, temp = 0, [screws[i]]
        front, back = screws[i]
        j = 0
        while j < n:
            if screws[j] in temp:
                j += 1
                continue
            if back == screws[j][0]:
                count += 1
                back = screws[j][1]
                temp.append(screws[j])
                j = 0
                continue
            j += 1
        else:
            if count > max_cnt:
                max_cnt = count
                answer = temp
    return answer


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        n = int(input())
        input_list = list(map(int, input().split()))
        screws = [[input_list[i * 2 + j] for j in range(2)] for i in range(n)]
        answer = solution(screws)
        print_answer(test_case + 1, answer)


if __name__ == '__main__':
    main()
