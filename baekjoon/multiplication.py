#-*- coding: utf-8 -*-
#python3
a = input()
b = input()
for i in b[::-1]: # [::-1] 역순으로
    print(int(a)*int(i))
print(int(a)*int(b))
