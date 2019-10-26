#-*- coding:utf-8 -*-
import sys
import time
start = time.time()
T=int(sys.stdin.readline().rstrip())

# def count(d,k):


for i in range(T):
    # x, y = map(int,sys.stdin.readline().split())
    # 시간측정
    #x = 0; y= 2147483647 #시간 오바됨.
    x=0
    for y in range(30):
        k=1; n=0; c=2
        d = y-x #거리
        print('d : ',d)
        while d>0:
            print('d :', d)
            if d-k>=0:
                if c==0: k+=1; c=2
            else:
                k-=1
            # print('k : ',k)
            d = d-k
            c -= 1
            n += 1
            print('k : ',k,',d : ',d, ',c : ', c , ',n : ',n)
        print(n)
        # print("time : ", time.time() - start)

#시간초과
