import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
cal = []            # 입력된 일정 리스트
calmap = [0]*366    # 일정을 표시할 달력

for i in range(N):  # 일정 입력
    S, E = map(int, input().strip().split())
    cal.append((S,E))

# 시작 일이 빠르고, 기간이 길수록 앞쪽으로 정렬
cal = sorted(cal, key = lambda x : (x[0], -x[1]))

for s, e in cal:    # 달력에 일정 표시
    for i in range(s,e+1):
        calmap[i] += 1

answer = 0
w = 0   # 임시 너비
h = 0   # 임시 높이
flag = False     # 코팅지 너비 체크 중 여부
for i in calmap: # 달력 확인
    if flag:        # 코팅지 너비 확인 X
        if i != 0:  # 코팅지 너비 확인 시작
            flag = True
            w += 1
            h = i
    else:           # 코팅지 너비 확인중
        if i == 0:  # 코팅지 너비 확인 종료
            flag = False
            answer += w*h
            w = 0
            h = 0
        else:
            if i > h:
                h = i
            w += 1
            
answer += w*h # 코팅지 너비 확인 중 종료됐을때 남은거 더해주기

print(str(answer))