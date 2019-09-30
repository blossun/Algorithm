key = [1,2,3,4,5,6,7,8]
# r_key = list(reversed(key))

x = list(map(int,input().split()))
r_x = list(reversed(x))

result = 0
for i,val in enumerate(x):
    #print(i, val, key[i])
    if key[i] == val: result='asc'
    else: result="mix"; break

if result != 'asc':
    for i,val in enumerate(r_x):
        if key[i] == val: result='dsc'
        else: result="mix"; break

if result=='asc': print('ascending')
elif result=='dsc': print('descending')
else: print('mixed')


""" 다른풀이(1)
lst = list(map(int,input().split()));

if lst == [1,2,3,4,5,6,7,8]:
    print("ascending");

elif lst == [8,7,6,5,4,3,2,1]:
    print("descending");

else:
    print("mixed");


"""

""" 다른풀이(2)
import sys

Scale_list = list(map(int,sys.stdin.readline().split()))
a = 0
d = 0
m = 0
for i in range(len(Scale_list)-1):
    if (Scale_list[i]<Scale_list[i+1]):
        a = a+1
    elif(Scale_list[i]>Scale_list[i+1]):
        d = d+1

    else:
        m = m+1

if(a==7):
    print('ascending')
elif(d==7):
    print('descending')
elif(a!=7 & d!=7):
    print('mixed')


"""
