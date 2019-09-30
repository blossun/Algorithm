"""
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

예를 들어, 서로 다른 9개의 자연수

3, 29, 38, 12, 57, 74, 40, 85, 61

이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.

"""

#입력 받는 수가 '자연수'로 정해져있으니깐 초기최댓값을 0 으로 둬도 괜찮음
#num = []
#print(type(num))
i = 0
while i < 9:
    #num.append(int(input()))
    #pre = num[i]
    num = int(input())
    if i==0: max=num; max_i = i+1 #첫번째 입력값을 초기 최댓값으로 설정
    else:
        if num > max: max = num; max_i = i+1
    i += 1
print(max)
print(max_i)
