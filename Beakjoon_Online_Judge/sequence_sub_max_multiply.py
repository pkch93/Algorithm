def solution(nums):
    n = len(nums)
    dp = [1]*n
    for i in range(n):
        if i == 0:
            dp[0] = nums[0]
        else:
            dp[i] = max(dp[i-1]*nums[i], nums[i])
    return max(dp)


def main():
    n = int(input())
    nums = []
    for _ in range(n):
        nums.append(float(input()))
    nums = tuple(nums)
    print("%.3f" % (solution(nums)))


if __name__ == '__main__':
    main()
