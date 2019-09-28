#_python3
grade = {10:'A', 9:'A', 8:'B', 7:'C', 6:'D'}
score = int(input())
# 이전 코드
# if score//10 in grade:
#     print(grade.setdefault([score//10], 'F'))
# else:
#     print('F')

# 코드 줄이기
myG = grade.setdefault(score//10, 'F') #grade dic에 없는 경우 기본값으로 'F' 저장
print(myG)

'''
# 코드길이 91byte
grade = {10:'A', 9:'A', 8:'B', 7:'C', 6:'D'}
print(grade.setdefault(int(input())//10, 'F'))
'''
