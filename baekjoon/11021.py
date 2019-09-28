#-*- coding:utf-8 -*-
'''
각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력

print에 바로 출력하려고 하면 띄어쓰기 출력형식이 맞지 않아서, 문자열로 결합 후 출력

'''
import sys
n = int(sys.stdin.readline().rstrip())
for i in range(1,n+1):
    x,y = map(int, sys.stdin.readline().rstrip().split())
    case = "Case #"+str(i)+": "
    print(case+str(x+y))
