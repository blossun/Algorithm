year = int(input())
result = 1
if year%400 != 0:
    if year%4 == 0:
        if year%100 == 0:
            result=0
    else:
        result=0
print(result)

'''
#짧은 코드
if x%4==0 and (x%100!=0 or x%400==0):
    print(1)
else:
    print(0)

'''
