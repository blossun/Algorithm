a = raw_input().split()
print int(a[0]) + int(a[1])

'''
python2에서는 raw_input() 함수로 사용자로 부터 입력을 받는다.
입력받은 값을 split( ) 함수를 이용해 space를 구분자로 하여 a 배열의 각 인덱스에 값을 저장한다.

첫번째 입력값 a[0]을 float 형으로 변환하고, 두번째 입력값 a[1]을 float 형으로 변환하여 나눈 값을 출력하면 된다.
'''
