# -*- coding: utf-8 -*-
import time
import sys
start = time.time()
A,B,C = map(int, sys.stdin.readline().rstrip().split())
# print(A,B,C)

# 1. 반복문 돌리면 시간이 오래걸림 - 시간초과
# i=1
# while(True):
#     if(A+B*i < C*i): print(i); break
#     i += 1

# 2. 방적식 세워서 결과 출력해야된다.
if(B>=C): print(-1)
else: print(A//(C-B)+1)


print("time :", time.time() - start)
