import sys

str = sys.stdin.readline().rstrip()

tag = False
answer = ""
temp = ""

for c in str :
    if c == '<':
        tag = True
        answer += temp[::-1]
        temp = ""
        answer += c
    elif c == '>':
        tag = False
        answer += c
    elif c == ' ':
        answer += temp[::-1]
        temp = ""
        answer += ' '
    elif tag :
        answer += c
    else :
        temp += c
if temp != "":
    answer += temp[::-1]

sys.stdout.write(answer)