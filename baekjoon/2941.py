import sys
str = list(sys.stdin.readline().rstrip())
cro_alpha = ["c=","c-","dz=","d-","lj","nj","s=","z="]
# print(str,len(str))
cnt = 0
i=0
while i < len(str):
    if i < len(str)-2:
        if str[i]+str[i+1]+str[i+2] in cro_alpha:
            # print(str[i]+str[i+1]+str[i+2])
            i+=3; cnt+=1; continue
    if i < len(str)-1:
        if str[i]+str[i+1] in cro_alpha:
            # print(str[i]+str[i+1])
            i+=2; cnt+=1; continue
    i+=1
    cnt+=1
print(cnt)
# print(cnt)


""" short coding
import re
print(len(re.sub('dz=|[ln]j|\w\W','Z',input())))

"""
