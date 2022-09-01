for _ in range(int(input())):
    n = int(input())
    weardict = {}
    for _ in range(n):
        wear = list(input().split())
        if wear[1] in weardict:
            weardict[wear[1]].append(wear[0])
        else:
            weardict[wear[1]] = [wear[0]]
    print(weardict)
    cnt = 1 
    for k in weardict:
        cnt *= (len(weardict[k])+1)
    print(cnt-1)