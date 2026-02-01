gadan = ['A','D','E']
dajang = ['C','F','G']

music = input().split("|")
ga = 0
da = 0

for m in music:
    if m[0] in gadan:
        ga += 1
    elif m[0] in dajang:
        da += 1

if ga == da:
    if music[-1][-1] in gadan:
        print("A-minor")
    else:
        print("C-major")
else:
    if ga > da:
        print("A-minor")
    else:
        print("C-major")