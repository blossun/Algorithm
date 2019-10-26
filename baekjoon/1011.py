import sys
T=int(sys.stdin.readline().rstrip())

for i in range(T):
    x, y = map(int,sys.stdin.readline().split())

    k=1; n=0; c=2
    d = y-x
    # print('d : ',d)
    while d>0:
        # print('d :', d)
        if d-k>=0:
            if c==0: k+=1; c=2
        else:
            k-=1
        d = d-k
        c -= 1
        n += 1
    print(n)
