import sys
input = sys.stdin.readline

n, m = map(int, input().split())
for _ in range(m):
    book = int(input())
    books = list(map(int,input().split()))
    for i in range(book-1):
        if books[i] < books[i+1]:
            print("No")
            exit(0)
print("Yes")