n = int(input())
arr = list(input())[:-1]
answer = 0

nextL = False
left = True # 왼쪽 컵홀더 사용이 되는가
for i in arr:
    if i == 'S': # 일반 좌석
        answer += 1
    elif not nextL:   # 커플 좌석 왼쪽
        nextL = True
        if left:
            answer += 1
    else:             # 커플 좌석 오른쪽
        nextL = False
        answer += 1
        left = False
    print(i, answer)
print(answer + 1)