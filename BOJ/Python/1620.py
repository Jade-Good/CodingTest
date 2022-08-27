import sys

n, m = map(int, sys.stdin.readline().split())

book = {}
number = 1
for i in range(n):
    poket = sys.stdin.readline().rstrip()
    if poket not in book:
        book[poket] = number
        number += 1

book_reverse = dict(map(reversed, book.items()))
for i in range(m):
    find = sys.stdin.readline().rstrip()
    if find[0] < "0" or find[0] > "9":
        sys.stdout.write(str(book[find]) + "\n")
    else:
        sys.stdout.write(book_reverse[int(find)] + "\n")