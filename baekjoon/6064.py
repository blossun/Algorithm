import sys
import math

def lcm(a, b, gcd):  #최소공배수 구하기
    return a*b//gcd

def main():
    N = int(sys.stdin.readline().rstrip())
    for i in range(N):
        M, N, x, y = map(int, sys.stdin.readline().rstrip().split())

        last = lcm(M, N, math.gcd(M,N)) #최소공배수가 마지막 해
        cnt = x
        while cnt <= last:
            # print('cnt : ', cnt)
            i = 0; end=0
            while True:
                # print('cnt-N*i : ',cnt-N*i)
                if (cnt - N*i) == y : print(cnt); end=1; break
                i += 1
                if (cnt - N*i) < 0: break
            cnt += M

            if end==1: break
        if end==0: print(-1)

if __name__ == "__main__":
    main()

#답은 맞는데 시간초과
"""
40000 39999 40000 39999
39999 2 39998 2
8 2 4 2
10 12 2 12
10 1 5 1

1599960000
39998
4
12
5
"""
