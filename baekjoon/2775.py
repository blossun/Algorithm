import sys
N = int(sys.stdin.readline().rstrip())

for i in range(N):
    y = int(sys.stdin.readline().rstrip())
    x = int(sys.stdin.readline().rstrip())
    apt = [[0 for w in range(y+1)] for h in range(x+1)]
    print(apt)
    for num in range(1,x+1):
        print(num, apt[num][0])
        apt[num][0] = num
    for i in range(len(apt[1])):
        # print(i)
        apt[1][i] = 1
        # print(apt[1][num])

    # for i in range(len(apt)):
    #     print(i, apt[i])
    #     apt[i][0] = i
    # for i in range(len(apt)):
    #     apt[1][i] = 1

    # for i in range(len(apt)):
    #     print('i : ', i)
    #     for j in range(len(apt[i])):
    #         print('j : ', j)
    #         if i==0: apt[i][j]=1
    #         if j==1: apt[i][j]=i


    print(apt)
    for w in range(2,x+1):
        for h in range(1,y+1):
            print('w:',w,',h:',h)
            apt[w][h] = apt[w][h-1] + apt[w-1][h]
            print("apt[",w,"][",h,"] : ", apt[w][h])

    print(apt)
    print(apt[x][y])
