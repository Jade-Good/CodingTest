arr = [1,1]

for _ in range(int(input())-1):
    arr.append((arr[-1]+arr[-2]*2)%10007)

print(arr[-1])