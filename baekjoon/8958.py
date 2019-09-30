import sys
N = int(sys.stdin.readline().rstrip())
i=0
while i<N:
    i += 1
    #split string into list of characters
    result = list(sys.stdin.readline().rstrip())

    weight=0 #가중치
    score=0 #최종점수
    for x in result:
        if x.upper() == 'O':
            weight +=1
            score += weight
        else:
            weight = 0
    print(score)
