N = int(input())

order = list(input())
num = []
for i in range(N):
    num.append(int(input()))

stack = []
for i in order:
    if i >= 'A' and i <= 'Z':
        stack.append(num[ord(i)-ord('A')])
    else:
        if i == '*':
            stack.append(stack.pop() * stack.pop())
        elif i == '+':
            stack.append(stack.pop() + stack.pop())
        elif i == '/':
            b = stack.pop()
            a = stack.pop()
            stack.append(a / b)
        elif i == '-':
            b = stack.pop()
            a = stack.pop()
            stack.append(a - b)

print("{:.2f}".format(stack.pop()))