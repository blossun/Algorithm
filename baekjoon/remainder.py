#-*- coding: utf-8 -*-
#python3
#data = input().split()
int_data = []
for i in input().split():
    int_data.append(int(i))

#print(int_data)
print((int_data[0] + int_data[1])%int_data[2])
print((int_data[0]%int_data[2] + int_data[1]%int_data[2])%int_data[2])
print((int_data[0] * int_data[1])%int_data[2])
print((int_data[0]%int_data[2] * int_data[1]%int_data[2])%int_data[2]) #몫
# print(int(a[0]) % int(a[1])) # 나머지
# print(divmod(int(a[0]),int(a[1]))) #retValue[0] : 몫, retValue[1] : 나머지
