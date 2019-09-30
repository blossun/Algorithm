import sys
n = [int(sys.stdin.readline().rstrip()) for i in range(3)]

result = n[0] * n[1] * n[2]
# number to list
res = [int(x) for x in str(result)]
# print(res)

for i in range(10):
    print(res.count(i))
