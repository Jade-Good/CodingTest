x, y = map(int,input().split())
while x != 0 and y!= 0:
    if x > y:
        print("Yes")
    else:
        print("No")
    x, y = map(int,input().split())