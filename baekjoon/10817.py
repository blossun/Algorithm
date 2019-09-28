a,b,c = map(int, input().split())
if a>=b:
    if b>=c:
        print(b)
    elif a<c:
        print(a)
    else:
        print(c)
elif b>=c:
    if a>=c:
        print(a)
    else:
        print(c)
else:
    print(b)

'''
# sort() 함수로 정렬 후 출력 가능
a= list(map(int,input().split(' ')))
a.sort()
print(a[1])
'''
