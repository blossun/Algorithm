import sys,math
A,B,V = map(int,sys.stdin.readline().rstrip().split())


#식 : Ax -B(x-1) >= V 일 때, x의 값
# B에 x-1을 하는 이유는 한 번 정상에 올라가면 내려오지 않는다.
# x >= (V-B)/(A-B) 로 부등식을 풀어보자. 반올림한 값을 x로
# 파이썬 올림 - math.ceil
print(math.ceil((V-B)/(A-B)))

"""
#반복문 day값을 1씩 올리면서 찾으면, 2 1 1000000 값을 입력했을 때, 시간초과된다.
#시간 제한은 0.15초 이다.
day = 1
while True:
    if (A-B)*day + B >= V: print(day); break
    day += 1
"""
