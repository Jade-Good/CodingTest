import sys
input = sys.stdin.readline
print = sys.stdout.write

string = input().rstrip()
strs = []       # 오리 별 울음소리 저장
answer = 0      # 오리의 수
done = 0        # 끝난 울음 소리 수

duck = "quack"  # 울음소리 한 사이클
find = 0        # 사이클에서 찾는 문자

for c in string:
    if c == 'q': find = 4   # 이전 문자를 찾아야함
    elif c == 'u': find = 0
    elif c == 'a': find = 1
    elif c == 'c': find = 2
    elif c == 'k': find = 3
    
    isin = False            # 연결되는 울음 찾기
    for i in range(len(strs)):          # 울음 검사
        if strs[i][-1] == duck[find]:   
            strs[i] += duck[(find+1)%5]
            isin = True     # 연결되는 울음 찾음
            if find == 3:
                done += 1
            elif find == 4:
                done -= 1
            break
    if not isin:            # 연결되는 울음 못찾음
        strs.append("q")
        answer += 1

if answer == done:
    print(str(answer))
else:
    print(str(-1))