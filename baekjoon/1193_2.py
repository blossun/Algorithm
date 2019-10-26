# -*-coding:utf-8 -*-
import sys
N = int(sys.stdin.readline().rstrip())
# x: 분모, y:분자

#an = (n**2-n+2)/2
i=1
while True:
    if N < (i**2-i+2)/2: i-=1; break
    i+=1

c = int(N-((i**2-i+2)/2))
# print('i :',i,' c : ',c)
if i%2==0:
    print(str(1+c)+'/'+str(i-c))
else:
    print(str(i-c)+'/'+str(1+c))
#print(array[N-1])
#일반항을 구하고 해당 순서의 분수만을 구하면 시간초과되지 않음
