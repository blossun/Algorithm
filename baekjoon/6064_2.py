import sys
import math

def lcm(a, b, gcd):  #최소공배수 구하기
    return a*b//gcd

def main():
    N = int(sys.stdin.readline().rstrip())
    for i in range(N):
        M, N, x, y = map(int, sys.stdin.readline().rstrip().split())

        last = lcm(M, N, math.gcd(M,N)) #최소공배수가 마지막 해
        # print(last)
        cnt = x
        end=0
        while cnt <= last:
            # if M==x and N==y: print(last); end=1; break
            if (cnt % N) == y : print(cnt); end=1; break
            if (cnt % N) == 0 and N==y: print(cnt); end=1; break
            # print('cnt : ', cnt, '(cnt % N) : ', (cnt % N))
            cnt += M
        if end==0: print(-1)

if __name__ == "__main__":
    main()

#답은 맞는데 시간초과
