#-*- coding: utf-8 -*-
import sys
N = int(sys.stdin.readline().strip())

def an(n):
    return 3*i**2 - 3*i + 2

i=1
while True:
    # print(i,an(i))
    if N < an(i): print(i); break
    i+=1

#계차수열
# an = 2 8 20 38 62 ...
# bn = 6 12 18 24 .... = 6n
# an = a1 + b1 + .... + b(n-1)
