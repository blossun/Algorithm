import sys
cname = list(sys.stdin.readline().rstrip())
book = {'A':2,'B':2,'C':2,'D':3,'E':3,'F':3,'G':4,'H':4,'I':4,'J':5,'K':5,'L':5,'M':6,'N':6,'O':6,'P':7,'Q':7,'R':7,'S':7,'T':8,'U':8,'V':8,'W':9,'X':9,'Y':9,'Z':9}

time = 0
for c in cname:
    time += book[c]+1
print(time)


"""
print(sum(min(ord(c)-64,25)*28//89+3for c in input()))

"""

"""
print(sum(62-int(10000/(ord(v)+102))for v in input()))

"""

"""
숏코딩을 위해 입력받은 문자열을 리스트 컴프리헨션을 사용해 하나씩 계산하고 sum()으로 더해 출력했다.
문자를 ord()를 사용해 아스키코드로 변환하고 3으로 나눠서 더할때 최솟값이 3이 되도록 56을 뺀다.
7번의 PQRS와 9번의 WXYZ는 4개이기 때문에 그 이상의 아스키코드 값이 나오면 1씩 빼서 계산한다.

print(sum((ord(i) - 56 - int(ord(i)>82) - int(ord(i)>89)) // 3 for i in input()))



"""
