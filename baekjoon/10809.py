import sys
from operator import eq
S = list(sys.stdin.readline().rstrip())
idx = []
for c in range(ord('a'),ord('z')+1): # 범위 주의!!!!! ord('z') 하면 이거 전까지만 반복함 ㅜㅜㅜㅜㅜ
    for i,val in enumerate(S):
        index = '-1'
        if eq(chr(c),val):
            index = str(i)
            break
    idx.append(index)

print(" ".join(idx))
# for i in idx:
#     print(i, end=" ")

#범위 - 마지막 'z'를 검사안해서 계속 틀렸던 문제!! 주의하자 반복문 range 범위
