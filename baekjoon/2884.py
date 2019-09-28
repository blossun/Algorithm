time = input().split()
H = int(time[0])
M = int(time[1])
if M-45 < 0:
    if H-1 < 0:
        print(23, M+(60-45))
    else:
        print(H-1 ,M+(60-45))
else:
    print(H ,(M-45))

# 0:0 인 경우
# 24시 == 0
