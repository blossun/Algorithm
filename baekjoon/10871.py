n,x = map(int,input().split())
a = input().split()

for i in a:
    if (int(i)<x):
        print(i,end=" ")

#print는 default로 출력의 끝이 개행(new line)이다. end=""로 출력의 끝을 무엇으로 할 지 정해줄 수 있다.
