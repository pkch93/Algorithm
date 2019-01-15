import sys
sys.stdin = open("inputs/numcard_input.txt")

def solution(cards):
    """
    :param cards: integer값을 가지는 카드 리스트
    :return: tuple 형태의 카드 번호 / 갯수

    SW Expert Academy 4834. 숫자카드 (d2) / 시간복잡도 : O(n) 예상
    """
    count = [0] * 10
    # input이 0부터 9까지의 숫자이므로 갯수를 세기위한 count 리스트 생성
    for card in cards:
        count[card] += 1
    # card의 번호에 따라 count 리스트에 1씩 더해준다.
    max = -1, -1 # max 튜플을 초기화
    for idx, c in enumerate(count):
        # count의 index가 카드의 번호이므로 enumerate를 사용
        if max[1] <= c:
            # max 튜플의 2번째 값(index: 1)이 최대 갯수를 나타내므로 c와 비교
            max = idx, c # 크다면 max 변경
    return max

def main():
    T = int(input())
    for test_case in range(T):
        n, cards = input(), [int(card) for card in input()]
        max = solution(cards)
        print(f"#{test_case + 1} {max[0]} {max[1]}")

if __name__ == '__main__':
    main()