T = int(input())

for i in range(T):
    S = input()
    arr = S[0]
    flag = False
    for j in S[1:]:
        if j == '(': 
            arr += j
        else:
            if len(arr) == 0 or arr[-1] == ')':
                flag = True
                break
            else :
                arr = arr[:-1]
    
    if flag : print("NO")
    else:
        if len(arr) != 0: print("NO")
        else : print("YES")
