x = int(input())
line = 0
end = 0

while x > end:
    line += 1
    end += line

diff = end - x

if line % 2 != 0:
    u = diff + 1
    d = line - diff
else:
    u = line - diff
    d = diff + 1
print(f'{u}/{d}')