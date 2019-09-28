#-*- coding: utf-8 -*-
#입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보세요.
try:
    while True: #True 대문자 구분함
        x,y = map(int, input().split())
        #if x==0 and y==0: break #논리연산자 and
        print(x+y)
except EOFError:
    pass
'''
무한루프
계속 입력을 대기중이며 프로그램이 끝나지 않아 런타임 에러가 나게 됩니다.
더이상 입력이 없을 때 프로그램을 종료시키기 위한 구문이 필요합니다.

check eof(end of file) in python
'''
