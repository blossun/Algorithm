#-*- coding: utf-8 -*-
#python3
a = input().split()
print(int(a[0]) + int(a[1]))
print(int(a[0]) - int(a[1]))
print(int(a[0]) * int(a[1]))
print(int(a[0]) // int(a[1])) #몫
print(int(a[0]) % int(a[1])) # 나머지
print(divmod(int(a[0]),int(a[1]))) #retValue[0] : 몫, retValue[1] : 나머지
