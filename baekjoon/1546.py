import sys
N = int(sys.stdin.readline().rstrip())
nums = list(map(int,sys.stdin.readline().rstrip().split()))

# sum, max 함수
M = max(nums)
sum=0
for val in nums:
    sum += val/M * 100
print(sum/N)
