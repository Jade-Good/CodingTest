import sys

input = sys.stdin.readline

while(True):
    ss = input().rstrip()
    if ss == ".": break

    stack = []
    check = False
    for c in ss:
        if c == '(' or c == '[':
            stack.append(c)
        elif c == ')':
            if len(stack) == 0 or stack[-1] != '(': check = True
            else: stack.pop(-1)
        elif c == ']':
            if len(stack) == 0 or stack[-1] != '[': check = True
            else: stack.pop(-1)
    
    if check: print("no")
    else:
        if len(stack) != 0: print("no")
        else: print("yes")