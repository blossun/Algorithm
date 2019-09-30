"""
입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

"""
count = int(input())
i = 0
while i<count:
    i += 1
    # input value save with array
    num = [int(i) for i in input().split()]
    # print(num)
    sum = 0
    for x in num[1:]:
        sum += x
    average = sum/num[0]
    #print(average)

    r = 0
    for x in num[1:]:
        if x > average: r +=1
    #print(round(r*100/num[0],3),'%')
    print(format(r*100/num[0],'.3f')+'%')


"""
다른풀이
C = int(input())

for i in range(C):
    score = list(map(int,input().split(" ")))
    avg = sum(score[1:]) / score[0]

    count = 0

    for j in score[1:]:
        if j > avg:
            count += 1
    print(str("%.3f" % round(count / score[0] * 100, 3))+ "%")

"""
