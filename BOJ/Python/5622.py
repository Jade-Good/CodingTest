answer = 0
for c in list(input()):
    temp = ord(c)-ord('A')
    if temp < 15:
        answer += (ord(c)-ord('A'))//3 + 3
    elif 15 <= temp <=18:
        answer += 8
    elif temp > 21:
        answer += 10
    else:
        answer += 9
print(answer)