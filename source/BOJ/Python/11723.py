import sys

m = int(sys.stdin.readline())
s = set()

for i in range(m):
    order = sys.stdin.readline()

    if order[:3] == "add":
        s.add(int(order[4:]))
    elif order[:6] == "remove":
        x = int(order[7:])
        if x in s:
            s.remove(x)
    elif order[:5] == "check":
        sys.stdout.write(str(int(int(order[6:]) in s)) + "\n")
    elif order[:6] == "toggle":
        x = int(order[7:])
        if x in s:
            s.remove(x)
        else:
            s.add(x)
    elif order[:3] == "all":
        s = set(range(1,21))
    elif order[:5] == "empty":
        s = set()