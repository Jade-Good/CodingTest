from itertools import count
from sqlite3 import Cursor
import sys
from collections import Counter
from threading import currentThread

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
arr = []

for i in range(N):
    arr.append(int(input()))

arr.sort()

print(str(round(sum(arr)/N)) + "\n")
print(str(arr[N//2]) + "\n")
cnt = Counter(arr).most_common(2)
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]:
    print(str(cnt[1][0]) + "\n")
else:
    print(str(cnt[0][0]) + "\n")
print(str(arr[-1] - arr[0]) + "\n")

