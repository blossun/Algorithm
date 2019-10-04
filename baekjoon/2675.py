import sys
#테스트 케이스 수 T
T = int(sys.stdin.readline().rstrip())
for i in range(T):
    P = ""
    R = sys.stdin.readline().rstrip().split()
    for j in R[1]:
        P += j*int(R[0])
    print(P)
# print(P)
