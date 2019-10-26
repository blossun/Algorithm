import sys
N = int(sys.stdin.readline().rstrip())
x=0;y=0
min = -1

for i in range(N//5+1):
    # print(i)
    if (N-5*i)%3 == 0:
        x=i
        y=(N-5*i)//3
        # print('x, y :',x,y)
        if min == -1: min=x+y
        elif x+y<min: min=x+y

# print(x,y,min)
print(min)
