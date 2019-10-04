import sys
N = int(sys.stdin.readline().rstrip())
nums = list(map(int,sys.stdin.readline().rstrip()))

sum=0
for i in nums:
    sum+=i
print(sum)
