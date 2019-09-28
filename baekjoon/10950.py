n = int(input())
nums = []
for i in range(1,n+1):
    x,y = map(int, input().split())
    nums.append(x+y)
for i in nums:
    print(i)
