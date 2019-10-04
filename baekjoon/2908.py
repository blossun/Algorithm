import sys
num = sys.stdin.readline().rstrip().split()
re_num = []
for n in num:
    re_num.append(n[::-1])
if re_num[0] > re_num[1]: print(re_num[0])
else: print(re_num[1])
