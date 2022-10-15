string = list(input())
idx = 0
answer = 0
for s in string:
    next = ord(s) - ord('A')
    diff = abs(next - idx)
    if diff <= 13:
        answer += diff
    else:
        answer += 26 - diff
    idx = next
print(answer)