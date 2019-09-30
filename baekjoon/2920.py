key = [1,2,3,4,5,6,7,8]
r = []
x = map(int,input().split())
for i,val in enumerate(x):
    # print('key[i] : ',key[i],',val : ',val)
    if key[i]==val :
        r.append('1')
    elif key[7-i]==val:
        r.append('2')
    else:
        r.append('0')
#
# for i,val in enumerate(x):
#     print('key[7-i] : ',key[7-i], ', val :',val)
#     if key[7-i]==val:
#         r=2
#         continue
#     else:
#         r=0


# if r==8: print('ascending')
# elif r==16: print('descending')
# else: print('mixed')
print(r)
if r.count('1') == 8: print('ascending')
elif r.count('2') == 8: print('descendging')
else: print('mixed')
