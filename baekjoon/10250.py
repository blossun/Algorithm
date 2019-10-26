import sys,math
T = int(sys.stdin.readline().rstrip())
for i in range(T):
    H, W, N = map(int, sys.stdin.readline().rstrip().split())
    #방번호 YXX, YYXX (Y:층수, X:호수)
    # N/H 올림: 호수 , N%H : 층수
    X = str(math.ceil(N/H));
    if N%H == 0: Y=str(H)
    else: Y = str(N%H)
    print(Y+X.zfill(2))
