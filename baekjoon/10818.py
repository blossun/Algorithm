c = map(int,input().split())
x = list(map(int, input().split()))
min, max = x[0], x[0]
for i in x:
    #print('i',i)
    if i < min: min=i
    if i > max: max=i
print(min, max)

#use built-in function
#print(min(x), max(x))
