alphabet = input()

croatia = ("c=","c-","d-","lj","nj","s=","z=")
answer = 0
i = 0
while i < len(alphabet):
    if alphabet[i:i+2] in croatia:
        answer += 1
        i += 2
    elif alphabet[i:i+3] == "dz=":
        answer += 1
        i += 3
    else:
        answer += 1
        i += 1
print(answer)