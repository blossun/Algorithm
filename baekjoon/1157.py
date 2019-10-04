import sys
word = list(sys.stdin.readline().rstrip().upper())
alpha = {}
max = 0
max_c = ''
for s in range(ord('A'),ord('Z')+1):
    count = 0
    for c in word:
        if chr(s)==c: count+=1
    if count > max: max=count; max_c = chr(s)
    elif count == max: max_c = '?'
    else: continue
print(max_c)
    # alpha[s] = count
# for key in alpha.keys():
#     print(key, alpha[key])
#     if alpha[key] > max:
# print(max,max_c)


"""
a = input()
b = []

a=a.upper()

for i in range(65,91):
    b+=[[chr(i),a.count(chr(i))]]

b.sort(key=lambda x:-x[1])

if b[0][1] == b[1][1]:
    print("?")
else:
    print(b[0][0])

"""

""" 숏코딩 **파이썬 포인터 공부
s=input().upper();c=s.count;*_,a,b=v=sorted({*s,'?'},key=c);print(v[-(c(a)<c(b))])

"""
