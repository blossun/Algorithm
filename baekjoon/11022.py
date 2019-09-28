#-*- coding:utf-8 -*-
'''
각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력

print에 바로 출력하려고 하면 띄어쓰기 출력형식이 맞지 않아서, 문자열로 결합 후 출력

output print format
python3에서 %operator을 지원하지만 권장하지 않음
str.format 함수 사용

'''
import sys
n = int(sys.stdin.readline().rstrip())
for i in range(1,n+1):
    x,y = map(int, sys.stdin.readline().rstrip().split())


    # case 1
    #case = "Case #"+str(i)+": " + str(x) +" + "+str(y)+" = "+str(x+y)
    #print(case)
    # case 2
    # print("Case #%d: %d + %d =" %(i,a,b), a+b)
    # case 3
    result = 'Case #{}: {} + {} = {}'.format(i,x,y,x+y)
    print(result)
