n = int(input())

d = [0] * (n+1)

d[0] = 4
d[1] = 6

for i in range(2, n):
    d[i] = d[i-1] + d[i-2]

print(d[n-1])

# n = int(input())

# arr = [1, 1]

# if n == 1:
#     answer = 4
# elif n == 2:
#     answer = 6
# else:
#     for i in range(n-2):
#         arr.append(sum(arr[-2:]))
#     answer = arr[-1]*2 + sum(arr[-2:])*2
# print(answer)