n, m = map(int, input().split())

int(input())
stack1 = list(map(int,input().split()))
int(input())
stack2 = list(map(int,input().split()))

print(stack1)
print(stack1)

for i in range(1,n+1):
    if stack1[-1] == i:
        stack1.pop()
    elif stack2[-1] == i:
        stack2.pop()
    else:
        print("No")
        break
else:
    print("Yes")