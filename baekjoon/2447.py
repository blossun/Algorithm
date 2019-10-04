import sys
N = int(sys.stdin.readline().rstrip())

def star(k):
    s = [1 for i in range(1,N+1,k)]
    for i in s:
        if i==1: sys.stdout.write('*')
    print('\n')
    star(k+1)


star(1)
