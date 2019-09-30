import sys
nums = [int(sys.stdin.readline().rstrip()) for i in range(10)]
remains = set([])
for val in nums:
    x =  val % 42
    #if x not in remains: remains.append(x)
    # python set 집합자료형
    remains.add(x) #중복된값이 없을때만 값을 저장

# print(remains)
print(len(remains))
