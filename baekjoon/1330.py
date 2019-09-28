#python3
nums = input().split()
x = int(nums[0])
y = int(nums[1])
#x,y = map(int, input().split())
if x > y:
    print('>')
elif x < y:
    print('<')
else:
    print('==')

#map() 함수는 built-in 함수로 list 나 dictionary 와 같은 iterable 한 데이터를 인자로 받아 list 안의 개별 item을 함수의 인자로 전달하여 결과를 list로 형태로 반환해 주는 함수
