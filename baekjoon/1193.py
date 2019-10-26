# -*-coding:utf-8 -*-
import sys
N = int(sys.stdin.readline().rstrip())
# x: 분모, y:분자
array = ['1/1']
t=1
def addvalue(y,x):
    array.append(str(y)+'/'+str(x))

while len(array)<N:
    i=1
    t = t+1
    for a in range(t,0,-1):
        if t%2==0:
            addvalue(i,a)
        else:
            addvalue(a,i)
        i+=1
    """
    if t%2==0:
        for a in range(t,0,-1):
            x=a; y=i
            array.append(str(y)+'/'+str(x))
            i+=1
    else:
        for a in range(t,0,-1):
            y=a; x=i
            array.append(str(y)+'/'+str(x))
            i+=1
    """



print(array[N-1])
#시간초과 개선해서 다시 풀기
