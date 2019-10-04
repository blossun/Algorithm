import sys
N =  int(sys.stdin.readline().rstrip())
g_word = 0
for i in range(N):
    word = list(sys.stdin.readline().rstrip())
    alpha = [' ']
    check = 1
    for c in word:
        if c in alpha[0:-1]:
            # print('c in alpha : ',c)
            check=0
            break
        else:
            # print(alpha[-1])
            if alpha[-1]!=c:
                # print('c not in alpha: ', c)
                alpha.append(c)
    if check == 1:
        g_word += 1
print(g_word)

"""#숏코딩
r=0;exec("s=input();r+=all(s.find(c*s.count(c))+1for c in s);"*int(input()));print(r)

"""
