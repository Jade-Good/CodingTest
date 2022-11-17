n = int(input())
first = 1

while True:
    s = 0
    i = first
    for w in range(7):
        s += i
        i -= 1
        if i == 0:
            break
    if s >= n:
        print(first)
        break
    else:
        first += 1